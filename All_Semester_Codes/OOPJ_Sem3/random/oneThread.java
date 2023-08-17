/*
Multitasking is a process of executing multiple tasks simultaneously. We use multitasking to utilize the CPU. Multitasking can be achieved in two ways:

Process-based Multitasking (Multiprocessing)
Thread-based Multitasking (Multithreading)




What is synchronization and why use synchronization?

Garbage collection

Synchronization with synchronized method vs Synchronized block

Static synchronization

Sleeping a thread

Two ways to create a Thread

Life Cycle of a Thread

Joining a thread


setName()	to give thread a name
getName()	return thread's name
getPriority()	return thread's priority
isAlive()	checks if thread is still running or not
join()	Wait for a thread to end
run()	Entry point for a thread
sleep()	suspend thread for a specified time
start()	start a thread by calling run() method
activeCount()	Returns an estimate of the number of active threads in the current thread's thread group and its subgroups.
checkAccess()	Determines if the currently running thread has permission to modify this thread.
currentThread()	Returns a reference to the currently executing thread object.
dumpStack()	Prints a stack trace of the current thread to the standard error stream.
getId()	Returns the identifier of this Thread.
getState()	Returns the state of this thread.
getThreadGroup()	Returns the thread group to which this thread belongs.
interrupt()	Interrupts this thread.
interrupted()	Tests whether the current thread has been interrupted.
isAlive()	Tests if this thread is alive.
isDaemon()	Tests if this thread is a daemon thread.
isInterrupted()	Tests whether this thread has been interrupted.
setDaemon(boolean on)	Marks this thread as either a daemon thread or a user thread.
setPriority(int newPriority)	Changes the priority of this thread.
yield()	A hint to the scheduler that the current thread is willing to yield its current use of a processor.




priority by default is 5. Whenever a new Java thread is created it has the same priority as the thread which created it.i.e. main





Runnable Interface Method
It provides only single method that must be implemented by the class.

Method	Description
run()	It runs the implemented thread.



*/




public class oneThread extends Thread {
 

    public void run()
    {
 
     
        //System.out.println("Thread onethread is Running");// will be printed as many times as many there are objects of thread onethread
System.out.println(Thread.currentThread().getName()+" is running!");// gives name of which current obj of thread onethread is running
 
        // Try block to check for exceptions
        try {
           
            // making thread to sleep for 300 nano-seconds
           // using sleep() method
            Thread.sleep(300);
        }
 
    
        catch (InterruptedException ie) {
        }
 
        // will be printed as many times as many there are objects of thread onethread
        System.out.println("an exception occured");
    }
 
   
    public static void main(String[] args)
    {
        // Creating threads using above class as
        // it is extending Thread class
        oneThread c2 = new oneThread();// the obj created first is c2 ->thread-0
       
       oneThread c1 = new oneThread(); //THREAD-1
       
 
        System.out.println("Name of obj of thread onethread created second  : "+c1.getName());    
        System.out.println("thread name created first : "+c2.getName());    


        // Starting threads
       c1.start();
      // c2.start();
 
      
        System.out.println("obj c1 of onethread is alive : " + c1.isAlive());
        System.out.println("obj c2 of onethread is alive : " + c2.isAlive()); // if c2.start is not written it will return false
// 2 objects of thread onethread are made , hence the run method will run twice 


oneThread obj = new oneThread();
System.out.println(obj.getName()+ " is created!");  // THREAD-2

		Thread c3 = new Thread(obj);
		c3.setName("c3threadobj");
		System.out.println(c3.getName()+ " is created!");   // THREAD-3 if c3.setName("c3threadobj"); is not written
		c3.start();// will print c3threadobj is running


System.out.println();  
System.out.println(); 
System.out.println(); 

System.out.println("Priorities Functions ->");
 
System.out.println();
System.out.println(); 
System.out.println(); 

//default priority of all threads is 5
System.out.println("Priority of the thread-0 is : " + c2.getPriority()); 
c1.setPriority(6);  
System.out.println("Priority of the thread-1 is : " + c1.getPriority()); 
System.out.println("Priority of the thread-2 is : " + obj.getPriority()); 
System.out.println("Priority of the thread-3 is : " + c3.getPriority());  

// main thread
System.out.println("Currently Executing The Thread : " + Thread.currentThread().getName());  // why does it print main thread ??
  
System.out.println("Priority of the main thread is : " + Thread.currentThread().getPriority()); 
 
    }
}