package com.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class MapLauncher2 {
	static Integer count;
	static String word;
	
	public static void main(String[] args) {
			Map<String, Integer> wordMap = new HashMap<>();
			System.out.println("Please enter a text");
		
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		String[] tokens = string.split(" ");
		for(String token: tokens) {
			word = token.toLowerCase().replace(",", "").replace(".", "");
			count = wordMap.get(word);
			if(count == null ) {
				wordMap.put(word, 1);
			}
			else
				wordMap.put(word, count + 1);
		}
		//convertToSet(wordMap);
	//	printMap(wordMap);
		//System.out.println("Mama.".replace(".", ""));
		NavigableSet<WordWrapper> wordWrappers = convertToSet(wordMap);
		printSet(wordWrappers);
		
		
	}

	private static void printSet(NavigableSet<WordWrapper> wordWrappers) {
		for(WordWrapper wordWrapper: wordWrappers){
			System.out.println(wordWrapper);
		}
		
	}

	private static NavigableSet<WordWrapper> convertToSet(Map<String, Integer> wordMap) {
		NavigableSet<WordWrapper> wordSet=new TreeSet<>();
		for(Map.Entry<String, Integer> e: wordMap.entrySet()){
			wordSet.add(new WordWrapper(e.getKey(), e.getValue()));
		}
		return wordSet;
	}

//	private static void printMap(Map<String, Integer> wordMap) {
//		Map<String, Integer> wordTreeMap = new TreeMap<>(wordMap);
//		Set<String> keys = wordTreeMap.keySet();
//		for(String key: keys) {
//			System.out.printf("%-20s%-10s \n", key, wordTreeMap.get(key));
//		}
//		
//	} 
	

}
