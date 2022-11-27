package com.day3.zookeeper;

public class Bat extends Mammal {
	public int energyLevel = 300;
	
	String fly() {
		energyLevel -= 50;
		return "PHEWWWWW...";
	}
	
	String eathumans() {
		energyLevel += 25;
		return "Bat has eaten a human";
	}
	
	String attackTown() {
		energyLevel -= 100;
		return "Bat has attacked a village";
	}
}
