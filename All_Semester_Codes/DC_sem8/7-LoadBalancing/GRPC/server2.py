import grpc
import time
from concurrent import futures
import example_pb2
import example_pb2_grpc
import psutil  
import threading

# Server addresses of other servers
OTHER_SERVERS = ['localhost:50051', 'localhost:50053']

class MyServiceServicer(example_pb2_grpc.MyServiceServicer):
    def __init__(self):
        self.request_counter = 0  # Initialize request counter
        self.lock = threading.Lock()  # Lock for thread safety

    def get_cpu_utilization(self):
        return psutil.cpu_percent()

    def MyMethod(self, request, context):
        with self.lock:
            self.request_counter += 1  # Increment request counter
            request_id = self.request_counter  # Use request counter as ID

        print(f"Received request with ID {request_id} and parameters: {request.parameter1}, {request.parameter2}")

        # Check local CPU utilization
        local_cpu_utilization = self.get_cpu_utilization()
        print(f"Local CPU Utilization: {local_cpu_utilization}%")

        if local_cpu_utilization > 80:  # If local CPU utilization is above 80%, forward the request
            print("Local server is overloaded. Trying to forward request to another server with lower CPU utilization...")

            min_utilization_server = None
            min_utilization = float('inf')

            for server in OTHER_SERVERS:
                print(f"Forwarding request to server {server}")
                with grpc.insecure_channel(server) as channel:
                    stub = example_pb2_grpc.MyServiceStub(channel)
                    response = stub.MyMethod(request)
                    return response

            print("All servers are unavailable or overloaded. Unable to process request.")
            return example_pb2.Response(message="All servers are unavailable or overloaded. Unable to process request.")
        
        else:
            print("Local server is free. Handling request locally.")
            return example_pb2.Response(message=f"Processed request with ID {request_id} and parameters: {request.parameter1}, {request.parameter2}")

# Function to periodically print local CPU utilization
def print_cpu_utilization(interval=5):
    while True:
        cpu_percent = psutil.cpu_percent()
        print(f"Local CPU Utilization: {cpu_percent}%")
        time.sleep(interval)

# Run server
def serve(port):
    # Start a separate thread to print local CPU utilization
    cpu_thread = threading.Thread(target=print_cpu_utilization, args=(5,), daemon=True)
    cpu_thread.start()

    # Start gRPC server
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    example_pb2_grpc.add_MyServiceServicer_to_server(MyServiceServicer(), server)
    server.add_insecure_port(f'[::]:{port}')
    server.start()
    server.wait_for_termination()

if __name__ == '__main__':
    serve(50052)  # Change port numbers for multiple servers
