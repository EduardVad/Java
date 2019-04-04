package com.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@FunctionalInterface
//interface ElementProcessor {
	//double process(int element, int element2);
interface ElementProcessor<T extends Number> {
	double process(T element);
}

@FunctionalInterface
interface ExecutiveFunction {
	 void process();
}

public class LambdaExample {

	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		intList.add(5);
		List<Double> doubleList = new ArrayList<>();
		doubleList.add(6.4);
		doubleList.add(8.6);
		doubleList.add(1.23);
		doubleList.add(4.13);
		doubleList.add(12.12);

		//processElements(intList, 4, (x, y)->Math.pow(x, y));
		//processElements(intList, 1, (x, y)->multiply(x, y));
		//processElements(intList, x -> Math.sin(x.doubleValue()));
	//	processElements(doubleList, x -> Math.sin(x.doubleValue()));
		
		TimeUtil.measure(() -> Arrays.sort(createRandomArray()));
	}
	
	//private static void processElements(List<Integer> intList, int a, ElementProcessor function) {
	
	private static <T extends Number> void processElements(List<T> intList, ElementProcessor function) {
		List<Double> doubleList1 = new ArrayList<>();
		
		for(Number i: intList) {
			//doubleList1.add(function.process(i, a));
			
			doubleList1.add(function.process(i));
		}
		System.out.println(doubleList1);
	}

//	private static double multiply(int a, int b) {
//		return a * b / 10.0;
//	}
	
	
	private static int[] createRandomArray() {
		int[] myArray = new int[10000000];
		Random r = new Random();
		for(int i = 0; i < myArray.length; i++) {
			myArray[i] = r.nextInt(myArray.length);
		}
		return myArray;
	}
	
	public static class TimeUtil {
		private static void measure(ExecutiveFunction function) {
			long start = System.currentTimeMillis();
			function.process();
			long end = System.currentTimeMillis();
			System.out.println("Time spent = " +  (end-start));
			
		}
		
	}
}
