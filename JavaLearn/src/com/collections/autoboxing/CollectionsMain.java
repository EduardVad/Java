package com.collections.autoboxing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectionsMain {

	public static void main(String[] args) {
		
		List<Integer> list = new LinkedList<Integer>();
		list.add(56);
		
		Double d = 57.78;
		double doub;
		doub = d; //d.doubleValue();
		
		
	//Array to List	
		String[] colors = {"yellow", "green", "blue"};
		LinkedList <String>ll = new LinkedList<>(Arrays.asList(colors));
		ll.add("black");
		
		
	  colors = ll.toArray(new String[ll.size()])	;
		for(String color: colors){
			System.out.println("Color: " + color);
		}
	}

}
