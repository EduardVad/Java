package com.multithreading.executors;

import java.util.Random;

public class GCBRunnable extends Random implements Runnable {
	boolean isDaemon;
	
	public GCBRunnable(boolean isDaemon) {
		this.isDaemon = isDaemon;
		
	}
	

	@Override
	public void run() {
		String threadType = isDaemon? " DAEMON " : " USER ";
		
		String threadDescription = threadType +  Thread.currentThread().getName();
		int max = 10000000;
		System.out.println("Starting " + threadDescription);
		for (int i = 0; i < max; i++) {
			int a = nextInt();
			int b = nextInt();

			if (!Thread.interrupted()) {

				if (i % 10000 == 0) {
					int gcd = computeGCD(a, b);
					if (gcd > 1) {
						System.out.println(
								"Running in " + threadDescription + ". The GCD of " + a + " and " + b + " is " + gcd);
					}
				}
			} else {
				System.out.println("Thread was interrupted");
				return;
			}

			//System.out.println("Leaving the thread " + threadDescription);
		}
	}

	private int computeGCD(int number1, int number2) {
		if (number2 == 0) {
			return number1;
		} else {
			return computeGCD(number2, number1 % number2);
		}

	}
}
