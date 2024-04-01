from concurrent import futures
import time
import grpc
import greet_pb2
import greet_pb2_grpc
import sys  # Add sys module

class GreeterServicer(greet_pb2_grpc.GreeterServicer):
    def ChattyClientSaysHello(self, request_iterator, context):
        delayed_reply = greet_pb2.DelayedReply()
        for request in request_iterator:
            print("ChattyClientSaysHello Request Made:")
            print(request)

            for countdown in range(5, 0, -1):
                print(f"Time left: {countdown}")
                time.sleep(1)

            delayed_reply.request.append(request)

        delayed_reply.message = f"You have sent {len(delayed_reply.request)} messages. Please expect a delayed response."
        return delayed_reply

    def InteractingHello(self, request_iterator, context):
        for request in request_iterator:
            print("request from client " + request.name + " received.", flush=True)
            time.sleep(5)  # Start processing a new req only after 5 seconds
            print(request, flush=True)

            hello_reply = greet_pb2.HelloReply()
            hello_reply.message = f"{request.greeting} {request.name}"

            # print("response to client " + request.name + " sent", flush=True)
            yield hello_reply
            time.sleep(1)  # Simulate server processing time

def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    greet_pb2_grpc.add_GreeterServicer_to_server(GreeterServicer(), server)
    server.add_insecure_port("localhost:50051")
    server.start()
    server.wait_for_termination()

if __name__ == "__main__":
    serve()
