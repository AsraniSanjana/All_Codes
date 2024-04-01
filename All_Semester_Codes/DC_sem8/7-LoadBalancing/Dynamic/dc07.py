class Server:
    def __init__(self, name, connections=0, weight=1, response_time=0):
        self.name = name
        self.connections = connections
        self.weight = weight
        self.response_time = response_time

class LeastConnectionBalancer:
    def __init__(self, servers):
        self.servers = servers

    def balance(self):
        return min(self.servers, key=lambda server: server.connections)

class WeightedLeastConnectionBalancer:
    def __init__(self, servers):
        self.servers = servers

    def balance(self):
        return min(self.servers, key=lambda server: (server.connections / server.weight))

class LeastResponseTimeBalancer:
    def __init__(self, servers):
        self.servers = servers

    def balance(self):
        return min(self.servers, key=lambda server: server.response_time)

def get_servers():
    servers = []
    num_servers = int(input("Enter the number of servers: "))
    for i in range(num_servers):
        name = input(f"Enter name for server {i+1}: ")
        servers.append(Server(name))
    return servers

def add_server(servers):
    name = input("Enter name for the new server: ")
    servers.append(Server(name))
    print(f"Server '{name}' added.")

def remove_server(servers, balancer):
    name = input("Enter name of the server to remove: ")
    removed_server = None
    for server in servers:
        if server.name == name:
            servers.remove(server)
            removed_server = server
            print(f"Server '{name}' removed.")
            break
    else:
        print(f"Server '{name}' not found.")
        return

    # Redistribute processes to other servers
    if hasattr(removed_server, "processes"):
        for process_name in removed_server.processes:
            if balancer:
                balanced_server = balancer.balance()
                balanced_server.connections += 1
                if not hasattr(balanced_server, "processes"):
                    balanced_server.processes = []
                balanced_server.processes.append(process_name)
                print(f"Process '{process_name}' reassigned to {balanced_server.name}.")
            else:
                print("No load balancer found.")
    else:
        print(f"No processes to redistribute from '{name}'.")

def add_process(balancer):
    name = input("Enter name for the new process: ")
    balanced_server = balancer.balance()
    balanced_server.connections += 1
    print(f"Process '{name}' added. Assigned to {balanced_server.name}.")

    if not hasattr(balanced_server, "processes"):
        balanced_server.processes = []
    balanced_server.processes.append(name)

    print("Load distribution after adding process:")
    for server in balancer.servers:
        if hasattr(server, "processes"):
            print(f"{server.name}: {server.connections} connection(s): {', '.join(server.processes)}")
        else:
            print(f"{server.name}: {server.connections} connection(s)")

def remove_process(balancer, servers):
    name = input("Enter the name of the process to remove: ")
    for server in servers:
        if hasattr(server, "processes") and name in server.processes:
            server.processes.remove(name)
            server.connections -= 1
            print(f"Process '{name}' removed from {server.name}.")
            break
    else:
        print(f"Process '{name}' not found.")

    print("Load distribution after removing process:")
    for server in balancer.servers:
        if hasattr(server, "processes"):
            print(f"{server.name}: {server.connections} connection(s): {', '.join(server.processes)}")
        else:
            print(f"{server.name}: {server.connections} connection(s)")

def print_load_distribution(servers):
    print("\nCurrent Load distribution:")
    for server in servers:
        if hasattr(server, "processes") and server.processes:
            print(f"{server.name} has {len(server.processes)} process(es): {', '.join(server.processes)}")
        else:
            print(f"{server.name} has 0 processes.")

def main():
    print("Dynamic Load Balancing Algorithms:")
    print("1. Least Connection")
    print("2. Weighted Least Connection")
    print("3. Least Response Time")

    choice = int(input("Enter your choice of load balancing algorithm: "))

    num_servers = int(input("Enter the number of servers: "))
    servers = []
    for i in range(num_servers):
        name = input(f"Enter name for server {i+1}: ")
        servers.append(Server(name))

    if choice == 2:
        for server in servers:
            server.weight = int(input(f"Enter weight for server {server.name}: "))
            
        

    elif choice == 3:
        
        for server in servers:
            server.response_time = float(input(f"Enter response time for server {server.name}: "))
            

    num_processes = int(input("Enter the number of processes: "))

    processes = []
    for i in range(num_processes):
        process_name = input(f"Enter name for process {i+1}: ")
        processes.append(process_name)

    print("\nInitial Load distribution:")
    for i, server in enumerate(servers):
        if i < num_processes % num_servers:
            server.connections = num_processes // num_servers + 1
        else:
            server.connections = num_processes // num_servers

        processes_per_server = processes[:server.connections]
        processes = processes[server.connections:]
        if processes_per_server:
            server.processes = processes_per_server
        print(f"{server.name}: {server.connections} connection(s)")

    print_load_distribution(servers)

    if choice == 1:
        balancer = LeastConnectionBalancer(servers)
    elif choice == 2:
        balancer = WeightedLeastConnectionBalancer(servers)
    elif choice == 3:
        balancer = LeastResponseTimeBalancer(servers)
    else:
        print("Invalid choice.")
        return

    while True:
        print("\nMenu:")
        print("1. Add Server")
        print("2. Remove Server")
        print("3. Add Process")
        print("4. Remove Process")
        print("5. Exit")

        option = int(input("Select an option: "))

        if option == 1:
            add_server(servers)
            print_load_distribution(servers)
        elif option == 2:
            remove_server(servers, balancer)  # Pass the balancer argument here
            print_load_distribution(servers)
        elif option == 3:
            add_process(balancer)
        elif option == 4:
            remove_process(balancer, servers)
        elif option == 5:
            print("Exiting...")
            break
        else:
            print("Invalid option.")

    print("Process balancing completed.")

if __name__ == "__main__":
    main()