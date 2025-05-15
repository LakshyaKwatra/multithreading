# Multithreading and Concurrency

- Concurrency: Multiple things happening at the same time.
- Java supports concurrency by allowing you to create threads that can execute code in separate paths within a program.
- These threads can perform different tasks simultaneously, thanks to Java's class libraries designed for concurrent programming.
- This enables tasks like background processing, loading data from a database, or maintaining server connections without interrupting the main program.

# Process

- A process is an instance of a running program, meaning the execution of a program.
- Processes are isolated, using their own private memory space and do not share data with other processes.
- This isolation can make processes more resource-intensive, especially if they are heavy-weight.
- For example, different programs running on your computer, like a web browser and a text editor, are separate processes.
- The CPU and OS can run many isolated processes at the same time, which we also call programs.

# Thread

- A thread is an execution path within a program, often considered a subprocess.
- It executes a specific piece of code and can run concurrently with other threads within the same process.
- Unlike processes, threads share data and memory with other threads in the same process, making them lightweight and resource-efficient.

# Multitasking

- Multitasking in computing refers to the ability of a computer to run multiple programs or applications simultaneously.
- The CPU and operating system achieve this by quickly switching between different tasks or portions of programs, executing each for a short period.
- This switching happens so fast that it appears as if all programs are running at the same time, even though only one task is executed at any given moment.
- This allows for efficient use of CPU resources and better overall system performance.

# Multithreading

- Switching between threads.
- Threads (subprocesses) can execute in the same way as multitasking.
- Threads can execute switching between one another within the application.
- For example, in a process, one thread might handle the user interface while another fetches data from a database. The execution can switch between them.
- This switching between threads happens really fast and its called multithreading.

## Benefits

- Better CPU and I/O utilization. While I/O tasks in your application are running, the CPU can switch to a different thread and execute it until the I/O task completes.
- Concurrency
- Improved responsiveness
- Long running tasks can run in their own thread without impacting other subprocesses.

Multitasking and Multithreading follow the same basic principle, but they are two distinct terms used to describe things that are happening at slightly different levels in program execution

# The Main Thread

- The main thread in Java is a special thread created by the Java Virtual Machine (JVM) to run the main method of your Java class.
- When you execute the main method, it is run by this main thread.
- You can identify the main thread by using the `Thread.currentThread().getName()` method, which will return "main".
- java.lang.Thread
- This is the default thread that all Java programs start with, and you can create and start additional threads to run in parallel with the main thread. This is a key aspect of Java's multithreading capabilities.

# Daemon Threads

- Infrastructure thread.
- Runs in the background to perform tasks like
    - Garbage collection
    - GUI event dispatching
- Examples: Java Garbage Collector thread, Swing event dispatcher thread

# Non-Daemon (User) Threads

- Isn’t an infrastructure thread
- Performs user-defined program tasks
- Main thread is a non-daemon thread
- Any newly created thread inherits the Daemon status from its parent thread.
- All threads created inside the main method are non-daemon by default.
- You can make change the daemon status of a thread using the setDaemon(true/false) method of the Thread class.
- This method should be called after creating the thread but before starting it. If not, then the method throws IllegalThreadStateException.
- Thread class also has a isDaemon() method to check the Daemon status of a thread.

| **Daemon Threads** | **Non-Daemon Threads** |
| --- | --- |
| Treated as low priority by JVM | Treated as high priority by JVM |
| If JVM finds any Daemon threads still running, it terminates them. | JVM waits for them to finish |
| Run infra level background tasks | Run program tasks |

# Thread class

- A Java thread is an object like any other Java object.
- A thread is an instance of Java.lang.Thread class or any of its subclass.
- The Thread class encapsulates attributes and behaviour of a thread.
    - Attributes: id, name, priority, state, etc.
    - Behaviour: start(), sleep(), join(), interrupt(), etc.
- An object of the Thread class or its subclass can represent a separate path of execution within a program.
- It can run in parallel with multiple other threads.

# Runnable Interface

- The running behaviour of a thread is represented by java.lang.Runnable interface.
- It is an Abstract representation of the running behaviour of a thread.
- It has a single method: `public void run()`
- The run method should be implemented, putting in it the block of code that’s executed as a thread. (The run method tells the thread what to do.)
- Every thread needs to implement the `run()` method.
    - Hence java.lang.Thread class implements Runnable interface by default, giving it a `public void run()` method.
    - This `run()` method should be overridden to implement the running behaviour of a thread.
    - Basically any subclass of the Thread class should provide its own implementation to the run() method.

You use the Thread class to create multiple separate paths of execution within your Java program.

You implement the Runnable interface to specify the running behaviour of your thread.

# Creating a Thread

## Extending the Thread class

```java
public class FirstThread extends Thread {
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
```

## Implementing the Runnable interface

```java
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
				// encapsulates the running behaviour that a thread needs to execute
        MyRunnable myRunnable = new MyRunnable(); 
        Thread thread = new Thread(myRunnable);
    }
}
```

# Starting a thread

- `start()` method of the `Thread` class
- It causes the thread to begin execution and trigger the running behaviour of the thread.
- Calling the `run()` method directly on a thread will not give it the multi-threaded behavior.
- Instead, it will execute the `run()` method in the current thread, causing the threads to run one after the other rather than concurrently.
- To achieve true multi-threading, you should call the `start()` method, which internally calls the `run()` method and allows the thread to run in its own path of execution.
- This ensures that multiple threads can run simultaneously.
- Hence DO NOT call the `run()` method to start a thread.
- There is no guarantee to the order of thread execution.
- Each thread gets its own priority value at the time of creation. (a value between `Thread.MIN_PRIORITY` (1) and `Thread.MAX_PRIORITY` (10))
- Thread priority decides when to switch from one running thread to another.

# Extend Thread class or Implement Runnable interface

- If we extend Thread class, we won’t be able to extend any other class since Java does not allow multiple inheritance.
- But if we implement Runnable interface, our Runnable class can implement other interfaces if required and can also extend from another class.
- Extending Thread class is inheritance and creates an is-a relationship (Tight coupling)
- Implementing Runnable interface is Aggregation and creates a has-a relationship (Loose coupling)

# Pausing a thread

- Static Method: `Thread.sleep(long milliseconds)`
- `Thread.sleep(long milliseconds, long nanoseconds)`
- When you call Thread.sleep(1000);, the current thread pauses for 1000 milliseconds (1 second). During this time:
    - The thread stays in a "Timed Waiting" state.
    - It doesn't consume CPU resources (it's not actively running).
    - After the sleep duration is over, the thread becomes Runnable again (ready to be picked up by the CPU scheduler).


```java
private static void demonstrateSampleSleep() {
    for(int i = 0; i < 5; i++) {
        if(i == 4) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(i + 1);
    }
}
```

# Interrupting a thread

- Instructing a thread to stop its task.
- Helpful when our program performs a long running task in a thread.
- When a thread is in the middle of its execution, the program might request a thread to finish doing its task early, even if its not complete
- Thread’s response to the interruption:
    - Developer decides action
    - The most common response would be to terminate itself.
- Instance methods: `void interrupt()`, `boolean isInterrupted()`
- Static methods: `static boolean interrupted()`
- `interrupt()` method:
    - `interrupt()` simply sets an internal flag (interrupted status) in case of active threads and throws an exception in case of blocked threads. What needs to be done next is up to us to decide.
    - is called on the thread object running the task that needs to be interrupted.
    - sets interrupted status flag to true.
    - If at the time of invoking the interrupt method, the thread is blocked due to a blocking method like sleep(), the interrupted status flag is cleared (set to false) and the blocking method throws InterruptedException. It gives us a chance to respond to the interruption request.
    - Termination code in the catch block, so that the task would end.

| **interrupted** | **isInterrupted** |
| --- | --- |
| returns flag value and clears flag value if its set | only returns flag value |
| static method | instance method |
| `Thread.interrupted()` | `threadObject.isInterrupted()` |

# Making a thread wait until another thread terminates

- If you create and start three threads in a sequence, the thread scheduler doesn’t start and end them in a specified order.
- Sometimes we need to make sure that the threads execute in a particular order because threads access the same data concurrently and it could lead to synchronization issues.
- Threads need to communicate with each other. For example, a thread could request other threads to wait until it finishes execution.
- The Thread class has a method named `join()` that does this.
    - When `join()` method is called ‘on’ a particular thread (T), it will make the current thread (calling thread, let’s say main), to wait until T finishes executing its task.
    - It is a blocking method, causes the calling thread to wait until another thread finishes execution.
    - Calling method could be interrupted while it waits, then it throws InterruptedException.
    - `join(millis)` , `join(millis,nanos)` : the calling thread waits for the other thread to execute for at most the specified time.

```java
public static void main(String[] args) throws InterruptedException {

        int[] scores = new int[10];
        Thread scoresStreamThread = new Thread(new ScoresStreamRunnable(scores));
        Thread averageScoreThread = new Thread(new AverageScoreRunnable(scores));

        scoresStreamThread.start();
        scoresStreamThread.join(); // this makes the main thread to wait for scoresStreamThread to terminate
        averageScoreThread.start(); // this thread only gets started once the scoresStreamThread terminates

    }
```

# Other useful Thread class methods

- `long getId()`
    - Invoked on Thread instance
    - Returns a unique identifier of the thread
    - Returns a positive long value
    - ID is generated at the time of thread creation
    - When the thread is terminated, the ID could be used by another thread.
- `String getName()`: Returns the name of the thread on which it is invoked.
- `int getPriority()`
    - Thread gets a priority at the creation time.
    - Ranges between MIN_PRIORITY(1) and MAX_PRIORITY(10)
- getState()
    - The getState() instance method returns the status of the thread on which it is invoked.
    - The return value is an enum constant defined in enum class Thread.state.
        - New
        - TERMINATED
        - TIMED_WAITING
        - WAITING
        - BLOCKED
        - RUNNABLE
- isAlive()
    - Can be invoked on a Thread to check if it is alive.
    - returns true if thread has been started and has not died yet.
    - returns false if the thread has died.
- currentThread()
    - static method
    - returns a reference to the currently executing thread object.
    - Get a reference to the current thread from anywhere when you don’t have direct access to the thread reference .

# synchronized

- The `synchronized` keyword in Java is used to **control access to blocks of code or methods** in a multithreaded environment.
- It helps to **prevent thread interference** and **memory consistency errors** by ensuring that only one thread can execute a block of synchronized code at a time.
- In multithreading, multiple threads can access and modify shared resources (like variables or objects). Without synchronization, two threads could:
    - Interleave operations in a way that causes inconsistent data
    - Overwrite changes made by other threads
    - Cause race conditions or visibility issues

# wait() vs join()

### `wait()`

- **Defined in**: `java.lang.Object`
- **Used for**: Waiting for a condition to be fulfilled (usually in conjunction with `notify()` or `notifyAll()`).
- **Purpose**: Pauses the current thread until another thread **notifies** it.
- **Context**: Used within synchronized blocks or methods.

Key Points:

- Must be called from a synchronized context (`synchronized` block or method).
- Releases the lock on the object while waiting.
- Used for inter-thread communication.
- Needs to be explicitly `notified` (via `notify()` or `notifyAll()`).

```java
synchronized(sharedObject) {
    while (!condition) {
        sharedObject.wait();  // Releases lock and waits
    }
}
```

### `join()`

- **Defined in**: `java.lang.Thread`
- **Used for**: Waiting for a **specific thread to die** (complete its execution).
- **Purpose**: The calling thread pauses execution until the thread on which `join()` was called has finished.

Key Points:

- Does **not** need to be in a synchronized block.
- Commonly used when one thread must wait for another to finish before proceeding.
- Overloaded versions allow timeout (`join(long millis)`).

```java
Thread t1 = new Thread(() -> {
    // some work
});
t1.start();

t1.join();  // Main thread waits until t1 finishes
```

# Producer-Consumer Problem

### Problem:

You have two kinds of threads:

- **Producer(s)**: create data and add it to a **shared buffer**
- **Consumer(s)**: take data from that buffer and process it

BUT:

- The **buffer** has limited capacity
- Producers must **wait** if the buffer is full
- Consumers must **wait** if the buffer is empty

This requires **synchronization** to prevent:

- Data corruption (race conditions)
- Overflow/underflow of the buffer
- Wasted CPU cycles (busy-waiting)

Ensure:

1. Data integrity in shared resources
2. Proper synchronization
3. No deadlocks or race conditions

# Coffman conditions for deadlock to occur

| Condition | Meaning |
| --- | --- |
| Mutual Exclusion | Forks can only be used by one philosopher at a time |
| Hold and Wait | A philosopher holds one fork and waits for another |
| No Preemption | A philosopher can’t be forced to release a fork |
| 🔁 Circular Wait | A circular chain of philosophers each waiting for a fork the next has |
