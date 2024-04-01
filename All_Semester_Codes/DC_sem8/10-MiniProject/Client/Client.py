import os
import sys
import grpc
import logging

# Get the absolute path of the 'protos' directory
protos_dir = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'protos'))

# Add the 'protos' directory to the Python path
sys.path.append(protos_dir)

# Import the generated gRPC files
import FileTransfer_pb2
import FileTransfer_pb2_grpc

def list_files(directory):
    files = []
    for filename in os.listdir(directory):
        if os.path.isfile(os.path.join(directory, filename)):
            files.append(filename)
    return files

def upload_file(stub, client_directory, server_directory, filename):
    client_filepath = os.path.join(client_directory, filename)
    server_filepath = os.path.join(server_directory, filename)
    with open(client_filepath, 'rb') as f:
        metadata = FileTransfer_pb2.MetaData(filename=filename, extension=os.path.splitext(filename)[1], directory=server_directory)
        request_iterator = (FileTransfer_pb2.UploadFileRequest(metadata=metadata, chunk_data=chunk) for chunk in iter(lambda: f.read(1024), b''))
        response = stub.UploadFile(request_iterator)
    return response

def download_file(stub, client_directory, server_directory, filename):
    server_filepath = os.path.join(server_directory, filename)
    client_filepath = os.path.join(client_directory, filename)
    metadata = FileTransfer_pb2.MetaData(filename=filename, directory=server_directory)
    response_iterator = stub.DownloadFile(metadata)
    with open(client_filepath, 'wb') as f:
        for response in response_iterator:
            f.write(response.chunk_data)

def run():
    # Connect to the gRPC server
    with grpc.insecure_channel('localhost:50051') as channel:
        stub = FileTransfer_pb2_grpc.GreeterStub(channel)
        
        client_directory = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'Client'))
        server_directory = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'Server'))
        
        while True:
            print("\nOptions:")
            print("1. Upload file")
            print("2. Download file")
            print("3. Close")
            choice = input("Enter your choice: ")
            
            if choice == '1':
                print("Available files for upload:")
                files = list_files(client_directory)
                for i, file in enumerate(files, start=1):
                    print(f"{i}. {file}")
                file_choice = input("Select a file to upload: ")
                try:
                    file_choice = int(file_choice)
                    if file_choice < 1 or file_choice > len(files):
                        raise ValueError
                    response = upload_file(stub, client_directory, server_directory, files[file_choice - 1])
                    print("Greeter client received:", response.message)
                except (ValueError, IndexError):
                    print("Invalid choice!")
            elif choice == '2':
                print("Available files for download:")
                files = list_files(server_directory)
                for i, file in enumerate(files, start=1):
                    print(f"{i}. {file}")
                file_choice = input("Select a file to download: ")
                try:
                    file_choice = int(file_choice)
                    if file_choice < 1 or file_choice > len(files):
                        raise ValueError
                    download_file(stub, client_directory, server_directory, files[file_choice - 1])
                    print("File downloaded successfully!")
                except (ValueError, IndexError):
                    print("Invalid choice!")
            elif choice == '3':
                break
            else:
                print("Invalid choice!")


if __name__ == '__main__':
    logging.basicConfig()
    run()
