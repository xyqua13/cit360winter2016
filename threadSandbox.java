package threadsRunnablesExecutorsSandbox;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Handler;

public class threadSandbox {
	public static void main(String[] args){
		runnableSandbox running = new runnableSandbox("Thread");// creates a reusable runnable object
		 Thread t = new Thread(running);//sets the resuable runnable
		 Thread t2 = new Thread(new runnableSandbox("Runnable"));//creates a new instance of runnable
		 t2.start();// starts thread 1 first 
		 t.start();// starts thread 0 second
		 //This proves two things, First that the threads are working and the runnables are working and second
		 //when you run two threads at the same time you can have a race condition. If the two threads 
		 //were editing the same variable you would never know which one would finish first and therefore 
		 //never be sure what the value of the variable would be. This is bad bad code.
		 
		 //executor example
		 ExecutorService executor = Executors.newFixedThreadPool(3);// creates an executor with a fixed pool of 3 threads
		 executor.execute(running);//notice the executor is using the runnable created for the thread
		 executor.execute(new runnableSandbox("Executor"));// new executor runnable
		 //Notice in the executor the trace shows the the pool and thread number
		 
		 try {
		      Thread.sleep(2000);//wait 2 seconds for other threads to finish
		} catch (Exception e) {}
		 
		 System.out.println("\n\n----------------------------------\n\n\n");
		 //NASTY Executor Trying to pass more than the max number of threads
		 //RESULT handled the threads by not running them 
		 executor.execute(new runnableSandbox("Executor 1"));// new executor runnable
		 executor.execute(new runnableSandbox("Executor 2"));// new executor runnable
		 executor.execute(new runnableSandbox("Executor 3"));// new executor runnable
		 executor.execute(new runnableSandbox("Executor 4"));// new executor runnable
		 executor.execute(new runnableSandbox("Executor 5"));// new executor runnable
		 executor.execute(new runnableSandbox("Executor 6"));// new executor runnable
		 executor.execute(new runnableSandbox("Executor 7"));// new executor runnable
		 executor.execute(new runnableSandbox("Executor 8"));// new executor runnable
		 executor.execute(new runnableSandbox("Executor 9"));// new executor runnable
		 executor.execute(new runnableSandbox("Executor 10"));// new executor runnable
		 
		 //Threads and executors using runnables free up your system to do mutiple taks. It is non 
		 //liniar in nature. ONe thread can load the map from the server the other thread can
		 // return the pin point locations to go on the map and yet another can show you the loading icon
		 
	}
}
