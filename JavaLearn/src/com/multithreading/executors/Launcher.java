package com.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Launcher {
	private static final int POOL_SIZE = 2;

	public static void main(String[] args) throws InterruptedException {
		boolean isDaemon = true; 
		
		System.out.println("Starting main thread");
		GCBRunnable r = new GCBRunnable(isDaemon);
	//	runInOneThread(r, isDaemon);
		runWithExecutors(r, isDaemon);
		Thread.sleep(10);
		System.out.println("Leaving the main thread");
	    
	}
	
	private static void runInOneThread(GCBRunnable r, boolean isDaemon) throws InterruptedException{
		Thread t1 = new Thread(r);
		t1.setDaemon(isDaemon);
		t1.start();
		
//		Thread.sleep(30);
		t1.interrupt();
	}

	private static void runWithExecutors (GCBRunnable r, boolean isDaemon) throws InterruptedException{
		ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
		for(int i=0; i<5; i++) {
			executorService.execute(r);
		}
		executorService.shutdown();
		
		executorService.awaitTermination(10, TimeUnit.SECONDS);
	}
}

