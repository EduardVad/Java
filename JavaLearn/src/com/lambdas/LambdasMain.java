package com.lambdas;

import java.util.Arrays;
import java.util.Comparator;

public class LambdasMain {

	public static void main(String[] args) {
		String[] colors = { "green", "brown", "black", "pink", "gray" };
		Player player1 = new Player("Alex", 100);
		Player player2 = new Player("Igor", 80);
		Player player3 = new Player("Victor", 80);
		Player player4 = new Player("John", 91);

		Player[] players = { player1, player2, player3, player4 };

		Arrays.sort(players, (o1, o2) -> {
			if ((o1.score - o2.score) != 0) {
				return o2.score - o1.score;
			}else {
				return o1.name.compareTo(o2.name);
			}		
		});

		System.out.println(Arrays.toString(players));

		Arrays.sort(colors, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1); // compare by the last character
			}
		});

		System.out.println(Arrays.toString(colors));

		Arrays.sort(colors, (String s1, String s2) -> {
			System.out.println("Hello world");
			return s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1);
		});// lambda

		System.out.println(Arrays.toString(colors));

	}

	private static class Player {
		String name;
		int score;

		private Player(String name, int score) {
			this.name = name;
			this.score = score;
		}

		public String getName() {
			return name;
		}

		public int getScore() {
			return score;
		}

		@Override
		public String toString() {
			return "Player [name=" + name + ", score=" + score + "]";
		}

	}

}
