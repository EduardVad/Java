package com.collectionsClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsRunner {

	public static void main(String[] args) {

//		List<String> colors = new ArrayList<>();
//		colors.add("yellow");
//		colors.add("blue");
//		colors.add("green");
//		colors.add("black");
//		
//		System.out.println("List before sorting: " + colors);
//		Collections.sort(colors);
//		System.out.println("List after sorting: " + colors);
		
		List<Card> deckOfCards = new ArrayList<>();
		for(Card.Face face: Card.Face.values()) {
			for(Card.Suit suit: Card.Suit.values()) {
				deckOfCards.add(new Card(suit, face));
			}
		}
		
//		System.out.println("Original deck of cards");
//		for(int i =0; i< deckOfCards.size(); i++) {
//			System.out.printf("%-20s %s", deckOfCards.get(i), (i+1)%4 ==0 ? "\n" : " ");
//		}
		
		//Shaffle the deck of cards	
		Collections.shuffle(deckOfCards);
		printOutput("Cards after shuffle\n", deckOfCards);
		
		//Collections.sort(deckOfCards);
		//Collections.sort(deckOfCards, Collections.reverseOrder());
		Collections.sort(deckOfCards, new CardComparator());
		printOutput("\n\nCards after sorting\n", deckOfCards);	
	}
	
	private static void printOutput(String description, List<Card> deckOfCards) {
		System.out.println(description);
		for(int i =0; i< deckOfCards.size(); i++) {
			System.out.printf("%-20s %s", deckOfCards.get(i), (i+1)%4 ==0 ? "\n" : " ");
		}
	}

	public static class Card implements Comparable<Card> {
		private enum Suit {
			SPADES, HEARTS, CLUBS, DIAMONDS
		};

		private enum Face {
			Ace, Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jeck, Quenn, King
		};

		private final Suit suit;
		private final Face face;

		private Card(Suit suit, Face face) {
			this.suit = suit;
			this.face = face;
		}

		public Suit getSuit() {
			return suit;
		}

		public Face getFace() {
			return face;
		}

		@Override
		public int compareTo(Card card) {
			Face[] values = Face.values(); // To array
			List<Face> faces = Arrays.asList(values);

			if (faces.indexOf(this.face) < faces.indexOf(card.getFace()))
				return -1;
			else if (faces.indexOf(this.face) > faces.indexOf(card.getFace()))
				return 1;
			else if (faces.indexOf(this.face) == faces.indexOf(card.getFace())) {
				return String.valueOf(suit)
					   .compareTo(String.valueOf(card.getSuit()));
			}
			return 0;
		}

		@Override
		public String toString() {
			return face + " of " + suit;
		}	
	}
	public static class CardComparator implements Comparator<Card>{
		List<Card.Face> faces = Arrays.asList(Card.Face.values());
		@Override
		public int compare(Card card1, Card card2) {
			if (faces.indexOf(card1.getFace()) < faces.indexOf(card2.getFace()))
				return 1;
			else if (faces.indexOf(card1.getFace()) > faces.indexOf(card2.getFace()))
				return -1;
			else if (faces.indexOf(card1.getFace()) == faces.indexOf(card2.getFace())) {
				return String.valueOf(card1.getSuit())
					   .compareTo(String.valueOf(card2.getSuit()));
			}
			return 0;
		}
		
	}
}
