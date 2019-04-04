package com.multithreading.producerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

	private static BlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);

	public static void main(String[] args) {
		new Thread(new Producer()).start();
		new Thread(new Consumer()).start();

	}

	private static class Producer implements Runnable {
		String[] messages = { "Lorem ipsum dolor sit amet, consectetur adipiscing elit,",
				"sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Ut enim ad minim veniam,",
				"quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
				"Duis aute irure dolor in reprehenderit in voluptate ",
				"velit esse cillum dolore eu fugiat nulla pariatur.",
				"Excepteur sint occaecat cupidatat non proident, ",
				"sunt in culpa qui officia deserunt mollit anim id est laborum.", "DONE" };

		@Override
		public void run() {
			try {
				produce();
			} catch (InterruptedException e) {
			}
		}

		public void produce() throws InterruptedException {
			Random r = new Random();
			for (int i = 0; i < messages.length; i++) {
				queue.put(messages[i]);
				System.out.println("Producing  " + messages[i] + " Queue size is " + queue.size());
				Thread.sleep(r.nextInt(2000));
			}
		}
	}

	private static class Consumer implements Runnable {
		@Override
		public void run() {
			try {
				consume();
			} catch (InterruptedException e) {
			}
		}
	}

	public static void consume() throws InterruptedException {
		Random r = new Random();
		while (true) {
			String message = queue.take();
			System.out.println("Consuming " + message + " Queue size is " + queue.size());
			if (!"DONE".equals(message)) {
				Thread.sleep(r.nextInt(500));
			} else {
				return;
			}
		}
	}
}
