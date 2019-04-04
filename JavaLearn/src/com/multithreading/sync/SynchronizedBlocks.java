package com.multithreading.sync;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedBlocks {
	private int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	private int[] b = { 0, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
	private List<Integer> intList1 = new ArrayList<>();
	private List<Integer> intList2 = new ArrayList<>();

	private final Object lock1 = new Object();
	private final Object lock2 = new Object();

	public static void main(String[] args) throws InterruptedException {
		SynchronizedBlocks sb = new SynchronizedBlocks();
		sb.copy();
	}

	private void copy() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread th1 = new Thread(new RunnerA());
		Thread th2 = new Thread(new RunnerB());
		th1.start();
		th2.start();
		
		long end = System.currentTimeMillis();
		System.out.println("Time taken: " + (end - start) + " ms");
	}

	private void copyArrayA() throws InterruptedException {
		synchronized (lock1) {
			for (int item : a) {
				intList1.add(item);
				System.out.println(intList1);
				Thread.sleep(100);
			}
		}
	}

	private void copyArrayB() throws InterruptedException {
		synchronized (lock2) {
			for (int item : b) {
				intList2.add(item);
				System.out.println(intList2);
				Thread.sleep(100);
			}
		}
	}

	private class RunnerA implements Runnable {
		@Override
		public void run() {
			try {
				copyArrayA();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private class RunnerB implements Runnable {
		@Override
		public void run() {
			try {
				copyArrayB();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
