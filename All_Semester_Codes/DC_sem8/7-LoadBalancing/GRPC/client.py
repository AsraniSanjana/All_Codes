import grpc
import example_pb2
import example_pb2_grpc
import random

# Server addresses
SERVER_ADDRESSES = ['localhost:50051', 'localhost:50052', 'localhost:50053']

# Load balancing policy
class LoadBalancer:
    def __init__(self):
        self.index = 0

    def choose_server(self):
        return SERVER_ADDRESSES[self.index]

    def update_server_index(self):
        self.index = (self.index + 1) % len(SERVER_ADDRESSES)

# Run client
def run(num_requests):
    load_balancer = LoadBalancer()
    requests_sent = 0

    print(f"Sending {num_requests} requests...")
    while requests_sent < num_requests:
        chosen_server = load_balancer.choose_server()
        print(f"Sending request to {chosen_server}")
        
        channel = grpc.insecure_channel(chosen_server)
        stub = example_pb2_grpc.MyServiceStub(channel)

        parameter1 = str(random.randint(1, 10))
        parameter2 = "test"
        request = example_pb2.Request(parameter1=parameter1, parameter2=parameter2)

        try:
            response = stub.MyMethod(request)
            print("Response:", response.message)
        except grpc.RpcError as e:
            print(f"Error sending request to {chosen_server}: {e.details()}")
        
        print()
        load_balancer.update_server_index()
        requests_sent += 1

    print("All requests sent.")

if __name__ == '__main__':
    num_requests = int(input("Enter the number of requests to send: "))
    run(num_requests)
