package com.hackathon.models;

public class TestDeck {

	public static void main(String[] args) {
		
		Deck myDeck = new Deck();
//		System.out.println("press w to play or");
//		System.out.println("press q to stop playing:");
//		String name = System.console().readLine();
//		while(!name.equals("q")) {
			System.out.println("----You Played----");
			int player = myDeck.randomCard();
			System.out.println("----Computer Played----");
			int computer = myDeck.randomCard();
			
			System.out.println("----Results----");
			if(player > computer) {
				System.out.println("You Win!");
			} else {
				System.out.println("YOUR A LOSER L");
			}
		}
//		System.out.println(player);
//		System.out.println(computer);
//		for (Card card: myDeck.getCards()) {
//			card.showCard();
//		}
	}
//}
