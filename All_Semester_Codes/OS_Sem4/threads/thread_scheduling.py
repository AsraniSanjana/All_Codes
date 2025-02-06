import matplotlib.pyplot as plt
import random

class Thread:
    def __init__(self, name, burst_time, priority=1):
        self.name = name
        self.burst_time = burst_time  # Total execution time needed
        self.priority = priority      # Lower number = higher priority

# Example Scheduling Algorithms

def round_robin(threads, quantum=2):
    timeline = []
    queue = threads[:]
    time = 0
    
    while queue:
        thread = queue.pop(0)
        if thread.burst_time > quantum:
            timeline.append((thread.name, time, time + quantum))
            time += quantum
            thread.burst_time -= quantum
            queue.append(thread)
        else:
            timeline.append((thread.name, time, time + thread.burst_time))
            time += thread.burst_time
    
    return timeline

def priority_scheduling(threads):
    sorted_threads = sorted(threads, key=lambda t: t.priority)
    timeline = []
    time = 0
    
    for thread in sorted_threads:
        timeline.append((thread.name, time, time + thread.burst_time))
        time += thread.burst_time
    
    return timeline

def plot_schedule(timeline, title="Scheduling Visualization"):
    fig, ax = plt.subplots(figsize=(10, 4))
    colors = {}
    
    for task in timeline:
        name, start, end = task
        if name not in colors:
            colors[name] = (random.random(), random.random(), random.random())
        ax.barh(1, end - start, left=start, color=colors[name], edgecolor='black', label=name)
    
    ax.set_yticks([])
    ax.set_xticks(range(0, timeline[-1][2] + 1, 1))
    ax.set_xlabel("Time")
    ax.set_title(title)
    plt.legend(loc='upper right')
    plt.show()

# Example Threads
threads = [
    
    Thread("B", 3, priority=1),
    Thread("C", 8, priority=3),
    Thread("A", 5, priority=2)
]

# Choose and plot scheduling
schedule = round_robin(threads, quantum=2)
plot_schedule(schedule, "Round Robin Scheduling")
