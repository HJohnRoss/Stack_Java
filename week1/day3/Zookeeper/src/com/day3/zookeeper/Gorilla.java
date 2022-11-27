package com.day3.zookeeper;

public class Gorilla extends Mammal {
	String throwSomething(){
		energyLevel -= 5;
		return "Gorilla has thrown something";
	}
	
	String eatBananas() {
		energyLevel += 10;
		return "Gorrilla likes the banana";
	}
	
	String climb() {
		energyLevel -= 10;
		return "Gorilla climbed a mountain";
	}
}
