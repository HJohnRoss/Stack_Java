package com.day3.zookeeper;

public class GorillaTest {

	public static void main(String[] args) {
		Gorilla gorilla1 = new Gorilla();
		System.out.println(gorilla1.throwSomething());
		System.out.println(gorilla1.eatBananas());
		System.out.println(gorilla1.throwSomething());
		System.out.println(gorilla1.eatBananas());
		System.out.println(gorilla1.climb());
		System.out.println(gorilla1.throwSomething());
		System.out.println("Gorilla's energy: " + gorilla1.displayEnergy());
	}
}
