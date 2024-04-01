import os
import sys
import grpc
from concurrent import futures
import logging

# Get the absolute path of the 'protos' directory
protos_dir = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'protos'))

# Add the 'protos' directory to the Python path
sys.path.append(protos_dir)

# Import the generated gRPC files
import FileTransfer_pb2
import FileTransfer_pb2_grpc

# Your Server implementation and other code here
def get_filepath(filename, extension):
    return f'{filename}{extension}'


class Greeter(FileTransfer_pb2_grpc.GreeterServicer):
    def SayHello(self, request, context):
        return FileTransfer_pb2.StringResponse(message=f'Hello, {request.name}! Your age is {request.age}')

    def UploadFile(self, request_iterator, context):
        data = bytearray()
        filepath = 'dummy'

        for request in request_iterator:
            if request.metadata.filename and request.metadata.extension:
                filepath = os.path.join(request.metadata.directory, request.metadata.filename)
                continue
            data.extend(request.chunk_data)
        with open(filepath, 'wb') as f:
            f.write(data)
        return FileTransfer_pb2.StringResponse(message='Success!')

    def DownloadFile(self, request, context):
        chunk_size = 1024

        file_path = os.path.join(request.directory, request.filename)
        with open(file_path, mode="rb") as f:
            while True:
                chunk = f.read(chunk_size)
                if chunk:
                    entry_response = FileTransfer_pb2.FileResponse(chunk_data=chunk)
                    yield entry_response
                else:  # The chunk was empty, which means we're at the end of the file
                    break

    def ListFiles(self, request, context):
        files = []
        # Fetch the list of files in the server directory
        server_directory = os.path.abspath(os.path.dirname(__file__))
        for filename in os.listdir(server_directory):
            if os.path.isfile(os.path.join(server_directory, filename)):
                name, extension = os.path.splitext(filename)
                files.append(FileTransfer_pb2.MetaData(filename=name, extension=extension))
        return FileTransfer_pb2.FilesList(files=files)

def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=4))
    FileTransfer_pb2_grpc.add_GreeterServicer_to_server(Greeter(), server)
    server.add_insecure_port('[::]:50051')  # Hardcoded port number
    server.start()
    logging.info("Server started. Listening on port 50051.")
    server.wait_for_termination()


if __name__ == '__main__':
    logging.basicConfig(level=logging.INFO)
    serve()
