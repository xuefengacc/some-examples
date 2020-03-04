package expdemo.multithread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class M1 {
	public static void main(String args[]) {
		//Thread and Runnable
		RunnableDemo r1 = new RunnableDemo("Thread-1");
		RunnableDemo r2 = new RunnableDemo("Thread-2");
		ThreadDemo t1 = new ThreadDemo();
		
		r1.start();
		t1.start();
		r2.start();
		
		//callable, future and executor
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Future<String>> list = new ArrayList<Future<String>>();
		Callable<String> callableDemo = new CallableDemo();
		for(int i=0;i<10;i++) {
			Future<String> future = executor.submit(callableDemo);
			list.add(future);
		}
		for(Future<String> f:list) {
			try {
				System.out.println(new Date() + f.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		executor.shutdown();
	}

}

//implements runnable interface
class RunnableDemo implements Runnable{

	private Thread t;
	private String threadName;
	
	RunnableDemo(String name){
		this.threadName = name;
		System.out.println("Creating "+ this.threadName);
	}
	
	@Override
	public void run() {
		System.out.println("Running "+ this.threadName);
		try{
			for(int i=0;i<5;i++) {
				System.out.println("Thread "+ this.threadName +"," + i);
				Thread.sleep(100);
			}
		} catch(InterruptedException e) {
			System.out.println("Thread " + this.threadName +" is interrupted");
		}
		System.out.println("Thread "+ this.threadName+ " exiting.");
	}
	
	public void start() {
		System.out.println("Starting "+this.threadName);
		if(t==null) {
			t = new Thread(this, this.threadName);
			t.start();
		}
	}
	
}

//extends thread class
class ThreadDemo extends Thread{
	//private String threadName;
	//private Thread t;
	
	//ThreadDemo(String name){
	//	this.threadName = name;
	//	System.out.println("Creating "+this.threadName);
	//}
	
	public void run() {
		//System.out.println(this.threadName+" is running");
		try {
			System.out.println("New Thread running");
			Thread.sleep(1000);
			System.out.println("New Thread exiting");
			
		} catch (InterruptedException e) {
			//System.out.println(this.threadName + "is interrupted");
		}
		//System.out.println(this.threadName+" is exiting");
	}
}

//callable example
class CallableDemo implements Callable<String>{

	@Override
	public String call() throws Exception {
		return Thread.currentThread().getName();
	}
	
}