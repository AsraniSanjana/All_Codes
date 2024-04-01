import greet_pb2_grpc
import greet_pb2
import grpc
import asyncio

async def get_client_stream_requests():
    while True:
        name = input("Please enter a name (or nothing to stop chatting): ")
        print("Request from "+name+ " sent.")

        if name == "":
            break

        hello_request = greet_pb2.HelloRequest(greeting="Hello", name=name)
        yield hello_request
        await asyncio.sleep(5)  #to simulate client waiting for a response from a server
        # print("Response from server to client "+ name+ " Received.\n----------------------------------------------")

async def run_synchronous():
    async with grpc.aio.insecure_channel('localhost:50051') as channel:
        stub = greet_pb2_grpc.GreeterStub(channel)

        delayed_reply = await stub.ChattyClientSaysHello(get_client_stream_requests())
        print(f"ChattyClientSaysHello Response Received: {delayed_reply.message}")
        print("Waiting for server countdown to end...")
        
async def run_asynchronous():
    async with grpc.aio.insecure_channel('localhost:50051') as channel:
        stub = greet_pb2_grpc.GreeterStub(channel)

        async def send_requests():
            async for response in stub.InteractingHello(get_client_stream_requests()):
                print(f"InteractingHello Response Received: {response.message}")
                # response for so and so received
        await asyncio.gather(send_requests(), send_requests(), send_requests())

def run():
    print("1. Synchronous Communication")
    print("2. Asynchronous Communication")
    communication_type = input("Choose communication type (1 or 2): ")

    if communication_type == "1":
        asyncio.run(run_synchronous())
    elif communication_type == "2":
        asyncio.run(run_asynchronous())
    else:
        print("Invalid choice. Please choose 1 or 2.")

if __name__ == "__main__":
    run()
