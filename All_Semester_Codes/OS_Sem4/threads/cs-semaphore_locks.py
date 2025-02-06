import tkinter as tk
from tkinter import ttk

class ThreadSynchronizationVisualizer:
    def __init__(self, root):
        self.root = root
        self.root.title("Thread Synchronization with Counting Semaphore")

        self.threads = []
        self.critical_section = []  # Stores threads in the critical section
        self.semaphore_value = 3  # Change this for more resource instances
        self.max_semaphore_value = self.semaphore_value  # Max instances

        self.setup_ui()

    def setup_ui(self):
        # UI for adding threads
        control_frame = ttk.Frame(self.root)
        control_frame.pack(pady=10)

        ttk.Label(control_frame, text="Thread Name:").grid(row=0, column=0)
        self.thread_name_entry = ttk.Entry(control_frame)
        self.thread_name_entry.grid(row=0, column=1)

        ttk.Button(control_frame, text="Add Thread", command=self.add_thread).grid(row=0, column=2)

        # UI for requesting access
        self.request_label = ttk.Label(control_frame, text="Request Critical Section:")
        self.request_label.grid(row=1, column=0)

        self.request_thread_entry = ttk.Entry(control_frame)
        self.request_thread_entry.grid(row=1, column=1)

        ttk.Button(control_frame, text="Request Access", command=self.request_access).grid(row=1, column=2)

        self.semaphore_label = ttk.Label(control_frame, text=f"Semaphore: {self.semaphore_value}/{self.max_semaphore_value}")
        self.semaphore_label.grid(row=1, column=3)

        # Critical section display
        self.critical_section_label = ttk.Label(self.root, text="Critical Section: EMPTY", font=("Arial", 12, "bold"), foreground="red")
        self.critical_section_label.pack(pady=20)

        # Listbox to show all threads
        self.thread_listbox = tk.Listbox(self.root, height=10, width=40)
        self.thread_listbox.pack(pady=10)

        # Logging section
        log_frame = ttk.Frame(self.root)
        log_frame.pack(pady=10)
        
        ttk.Label(log_frame, text="Activity Log:").grid(row=0, column=0)
        self.log_listbox = tk.Listbox(log_frame, height=10, width=60)
        self.log_listbox.grid(row=1, column=0)

        # UI for releasing specific threads
        release_frame = ttk.Frame(self.root)
        release_frame.pack(pady=10)

        ttk.Label(release_frame, text="Release Thread:").grid(row=0, column=0)
        self.release_thread_dropdown = ttk.Combobox(release_frame, state="readonly")
        self.release_thread_dropdown.grid(row=0, column=1)

        ttk.Button(release_frame, text="Release Selected", command=self.release_selected_thread).grid(row=0, column=2)

    def log_event(self, message):
        """Logs an event to the log section."""
        self.log_listbox.insert(tk.END, message)
        self.log_listbox.yview(tk.END)  # Auto-scroll

    def add_thread(self):
        thread_name = self.thread_name_entry.get()
        if thread_name and thread_name not in self.threads:
            self.threads.append(thread_name)
            self.thread_listbox.insert(tk.END, thread_name)
            self.log_event(f"Thread {thread_name} added.")

    def request_access(self):
        thread_name = self.request_thread_entry.get()

        if thread_name not in self.threads:
            self.log_event(f"ERROR: Thread {thread_name} not found.")
            return

        self.log_event(f"Thread {thread_name} requested access to Critical Section.")

        if self.semaphore_value > 0:
            self.critical_section.append(thread_name)
            self.semaphore_value -= 1
            self.update_critical_section_display()
            self.update_release_dropdown()
            self.log_event(f"Thread {thread_name} granted access. Semaphore set to {self.semaphore_value}.")
        else:
            self.log_event(f"Thread {thread_name} denied access! Semaphore = {self.semaphore_value}.")

        self.update_semaphore_display()

    def release_selected_thread(self):
        """Releases a specific thread from the critical section."""
        selected_thread = self.release_thread_dropdown.get()

        if selected_thread and selected_thread in self.critical_section:
            self.critical_section.remove(selected_thread)
            self.semaphore_value += 1
            self.update_critical_section_display()
            self.update_release_dropdown()
            self.log_event(f"Thread {selected_thread} left Critical Section. Semaphore set to {self.semaphore_value}.")
        
        self.update_semaphore_display()

    def update_critical_section_display(self):
        if self.critical_section:
            self.critical_section_label.config(text=f"Critical Section: {', '.join(self.critical_section)}", foreground="green")
        else:
            self.critical_section_label.config(text="Critical Section: EMPTY", foreground="red")

    def update_semaphore_display(self):
        self.semaphore_label.config(text=f"Semaphore: {self.semaphore_value}/{self.max_semaphore_value}")

    def update_release_dropdown(self):
        """Updates the dropdown to only show threads currently in the critical section."""
        self.release_thread_dropdown["values"] = self.critical_section
        if self.critical_section:
            self.release_thread_dropdown.current(0)
        else:
            self.release_thread_dropdown.set("")

if __name__ == "__main__":
    root = tk.Tk()
    app = ThreadSynchronizationVisualizer(root)
    root.mainloop()
