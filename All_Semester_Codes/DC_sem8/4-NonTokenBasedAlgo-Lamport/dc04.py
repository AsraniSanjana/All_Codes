

import time
def sleep(ms):
    time.sleep(ms / 1000)
def countdown_timer():
    for i in range(5, 0, -1):
        print(i)
        time.sleep(1)
if __name__ == "__main__":
    count_req = 0
    count_res = 0
    count_ok = 0  # reply msgs
    print("Enter number of Processes: ")
    n = int(input())
    interested_processes = []
    sort = [100] * n  # Initialize sort list with 100
    logical_time = 1
    for i in range(n):
        print(f"Does P{i + 1} want to enter the critical region? (yes/no)")
        choice = input().lower()
        if choice == "yes":
            interested_processes.append(i)
            while True:
                print(f"Enter non-negative timestamp for P{i + 1}: ")
                timestamp = int(input())
                if timestamp >= 0:
                    sort[i] = timestamp
                    break
                else:
                    print("Invalid timestamp! Please enter a non-negative integer.")
        else:
            sort[i] = 100


    print("\nTimestamps of processes who need the critical region:")
    for i in range(n):
        print(f"P{i + 1}: {sort[i] if i in interested_processes else '100'}")
    print()
    iterator = 0
    msg_overhead = 0
    start_time = time.time()
    while min(sort) != 100:
        min_val = min(sort)
        min_index = sort.index(min(sort))
        if iterator == 0:
            for i in range(n):
                if sort[i] != 100:
                    for j in range(n):
                        if i != j:
                            if sort[i] < sort[j]:
                                print(f"P{i + 1} -> REQ -> P{j + 1}")
                                count_req += 1
                            elif sort[i] == sort[j]:
                                print("Equal timestamps")
                                print("Decision is being made based on process ID")
                            else:
                                print(f"P{i + 1} -> REQ -> P{j + 1} (Invalid)")
                    count_req += 1
            for i in range(n):
                for j in range(n):
                    if j != min_index and i != j and sort[i] != 100:
                        print("    P" + str(i + 1) + " <- OK <- P" + str(j + 1))
                        count_ok += 1
                    if j == min_index and i != j and sort[i] != 100:
                        count_res += 1
        print("P" + str(min_index + 1) + " gets access to CR")
        countdown_timer()
        print(f"P{min_index + 1} has finished using the critical section")
        print("Identifying the next eligible process...")
        min_val = min(sort)
        min_index = sort.index(min(sort))
        sort[min_index] = 100
        next_min_val = min(sort)
        next_min_index = sort.index(min(sort))
        if next_min_val == 100:
            print("No more processes waiting for the critical section.")
        else:
            print(f"Next eligible process is P{next_min_index + 1} with timestamp {next_min_val}")
        print("")
        iterator += 1
        msg_overhead = count_req + count_res + count_ok
    end_time = time.time()
    print("Total number of request messages : ", count_req)
    print("Total number of reply messages : ", count_ok)
    print("Total number of release messages : ", count_res)
    print("Total message overhead : ", msg_overhead)
    print("Execution time = ", end_time - start_time)
