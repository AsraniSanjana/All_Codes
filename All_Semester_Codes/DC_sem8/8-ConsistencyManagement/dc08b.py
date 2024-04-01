class ClientCentricReadWriteConsistencyDatabase:
    def __init__(self):
        self.data = {}
        self.client_history = {}

    def read(self, key):
        if key in self.data:
            return self.data[key]
        else:
            return None

    def write(self, key, value, client_id):
        if key not in self.client_history:
            self.client_history[key] = []
        self.client_history[key].append((client_id, value))
        self.data[key] = (client_id, value)

def main():
    db_rw = ClientCentricReadWriteConsistencyDatabase()

    while True:
        print("\nOptions:")
        print("1. Write data")
        print("2. Read data")
        print("3. Exit")
        choice = input("Enter your choice: ")

        if choice == '1':
            key = input("Enter key: ")
            value = input("Enter value: ")
            client_id = input("Enter client ID: ")
            db_rw.write(key, value, client_id)
            print("Data written successfully!")
        elif choice == "2":
            key = input("Enter key to read: ")
            value = db_rw.read(key)
            if value is not None:
                client_id, val = value
                print(f"value for key '{key}' written by client {client_id}: {val}")
            else:
                print(f"No value found for key '{key}'")
        elif choice == "3":
            print("Exiting...")
            break
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()