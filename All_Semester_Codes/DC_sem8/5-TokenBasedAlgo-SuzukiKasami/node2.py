import grpc
import suzuki_kazami_pb2 as suzuki_kazami_pb2
import suzuki_kazami_pb2_grpc as suzuki_kazami_pb2_grpc
from concurrent import futures
import threading
import time
class Node(suzuki_kazami_pb2_grpc.SuzukiKazamiStub):
    def __init__(self):
        self.queue_data = []
        self.servers = ['localhost:50051','localhost:50053']
        self.has_token = False
        self.in_critical_section = False
    
    def change_token_status(self):
        self.has_token = not self.has_token
    def change_in_cs_status(self):
        self.in_critical_section = not self.in_critical_section
    
    def GetQueue(self,request, context):
        self.queue_data.append(request.data[-1])
        print(f'Get Queue:{self.queue_data}')
        return suzuki_kazami_pb2.QueueResponse(data=self.queue_data)

    def add_to_queue(self,data):
        channel = grpc.insecure_channel('localhost:50052')
        stub = suzuki_kazami_pb2_grpc.SuzukiKazamiStub(channel)
        request = suzuki_kazami_pb2.QueueRequest(data=data)
        # Add data to the request
        # request.data.extend(data)
        print(f'Request:{request}')
        # print(f'request.data.extend(data):{request.data.extend(data)}')
        # Send the request to the server
        response = stub.GetQueue(request=request)
                # Call updateQueue Here
        for server in self.servers:
            self.updateQueue(server,response.data)
        return response.data
    
    def UpdateQueue(self, request,context):
        self.queue_data.append(request.data[-1])
        return suzuki_kazami_pb2.QueueResponse(data=self.queue_data)

    # Server to Server functions 
    def updateQueue(self, server,updated_queue):
        channel = grpc.insecure_channel(server)
        stub = suzuki_kazami_pb2_grpc.SuzukiKazamiStub(channel)
        request = suzuki_kazami_pb2.QueueResponse(data=updated_queue)
        print(f'Request:{request}')
        response = stub.UpdateQueue(request=request)
        return response
    
    def show_queue(self):
        return self.queue_data
    
    def DeleteQueue(self,request,context):
        self.queue_data.pop()
        return suzuki_kazami_pb2.QueueResponse(data=self.queue_data)

    def deleteQueue(self,server):
        channel = grpc.insecure_channel(server)
        stub = suzuki_kazami_pb2_grpc.SuzukiKazamiStub(channel)
        request = suzuki_kazami_pb2.QueueResponse()
        print(f'Request:{request}')
        response = stub.DeleteQueue(request=request)
        return response
    
    def RequestToken(self, request,context):
        print(request.sequence_number)
        print(request.has_token)
        if request.has_token == True:
            self.enter_critical_section(request.site_id,request.sequence_number, request.in_critical_section,request.has_token,request.server_address)
        else:
            print('Wait until you recieve token')
            queue_data = self.add_to_queue(site_id)
        return suzuki_kazami_pb2.ReplyTokenMessage()

    def request_token(self,site_id,sequence_number,in_critical_section,has_token,server_address):
        channel = grpc.insecure_channel(server_address)
        stub = suzuki_kazami_pb2_grpc.SuzukiKazamiStub(channel)

        request = suzuki_kazami_pb2.RequestTokenMessage(site_id=site_id,sequence_number=sequence_number,in_critical_section=in_critical_section,has_token=has_token,server_address=server_address)
        # print(request.sequence_number)
        response = stub.RequestToken(request=request)
        return response
    def EnterCriticalSection(self,request,content):
        print(f'Node {request.site_id} Entered Critical Section')
        print('--------------------------------------------')
        return suzuki_kazami_pb2.ReplyTokenMessage(site_id=request.site_id,sequence_number=request.sequence_number,in_critical_section=request.in_critical_section,has_token=request.has_token,server_address=request.server_address)

    def enter_critical_section(self,site_id,sequence_number,in_critical_section,has_token,server_address):
        channel = grpc.insecure_channel(server_address)
        stub = suzuki_kazami_pb2_grpc.SuzukiKazamiStub(channel)

        request = suzuki_kazami_pb2.ReplyTokenMessage(site_id=site_id,sequence_number=sequence_number,in_critical_section=in_critical_section,has_token=has_token,server_address=server_address)
        print('Entered Critical Section from Client')
        response = stub.EnterCriticalSection(request=request)
        return response
    # From server 1 to another server
    def enter_Critical_Section(self,site_id,sequence_number,in_critical_section,has_token,server_address):
        channel = grpc.insecure_channel(server_address)
        stub = suzuki_kazami_pb2_grpc.SuzukiKazamiStub(channel)
        self.in_critical_section = True
        self.has_token = True
        request = suzuki_kazami_pb2.ReplyTokenMessage(site_id=site_id,sequence_number=sequence_number,in_critical_section=in_critical_section,has_token=has_token,server_address=server_address)
        # print('Entered Critical Section from Client')
        response = stub.EnterCriticalSection(request=request)
        return response
    
    def ReleaseCriticalSection(self,request,context):
        print(f'Release Critical Section by Node {request.site_id}')
        request.in_critical_section = False
        queue = self.show_queue()
        if len(queue) == 0:
            self.has_token = True
            print('No other Node requesting for Critical Section')
        else:
            self.has_token = False
            port = 50050 + int(queue[0])
            server_address = str(f'localhost:{port}')
            self.enter_Critical_Section(site_id=queue[0],sequence_number=1,in_critical_section=False,has_token=False,server_address=f'localhost:{str(port)}')
            self.queue_data.pop()
            for server in self.servers:
                self.deleteQueue(server)
        return suzuki_kazami_pb2.ReplyTokenMessage(site_id=request.site_id,sequence_number=request.sequence_number,in_critical_section=request.in_critical_section,has_token=request.has_token,server_address=request.server_address)
    def release_critical_section(self,site_id,sequence_number,in_critical_section,has_token,server_address):
        channel = grpc.insecure_channel(server_address)
        stub = suzuki_kazami_pb2_grpc.SuzukiKazamiStub(channel)
        self.has_token = False
        print('Release Critical Section Initialized')
        request = suzuki_kazami_pb2.ReplyTokenMessage(site_id=site_id,sequence_number=sequence_number,in_critical_section=in_critical_section,has_token=has_token,server_address=server_address)
        response = stub.ReleaseCriticalSection(request=request)
        return response
def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    node = Node()
    suzuki_kazami_pb2_grpc.add_SuzukiKazamiServicer_to_server(node, server)
    server.add_insecure_port('[::]:50052')
    server.start()
    print("Server started on port 50052")
    server.wait_for_termination()
    
if __name__ == '__main__':
    server_thread = threading.Thread(target=serve)
    server_thread.start()
    node = Node()

    # Wait for a moment to ensure the server is up and running
    time.sleep(1)
    # Entering Data
    server_address = 'localhost:50052'
    site_id = '2'
    sequence_number = 0

    try:
        while True:
        # Get data from the user to be sent in the queue request
            print('1. Request for Critical Section')
            print('2. Release the Critical Section')
            print('3. Check Queue')
            print('4. Check Sequence number')
            print('5. Change Token Status')
            print("6. Type 'Exit' to terminate")
            user_input = (input("Enter 1 to add information in the queue request (or 'exit' to quit): "))

            if user_input.lower() == 'exit':
                break

            # Run client with user-input data
            if user_input.lower() == '1':
                node.request_token(site_id,sequence_number,node.in_critical_section,node.has_token,server_address)
                sequence_number += 1
            elif user_input.lower() == '2':
                node.release_critical_section(site_id,sequence_number,node.in_critical_section,node.has_token,server_address)
            elif user_input.lower() == '3':
                print(node.queue_data)
            elif user_input.lower() == '4':
                print(sequence_number)
            elif user_input.lower() == '5':
                node.change_token_status()
    except KeyboardInterrupt:
        pass