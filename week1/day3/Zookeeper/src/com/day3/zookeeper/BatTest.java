package com.day3.zookeeper;

public class BatTest {

	public static void main(String[] args) {
		Bat bat1 = new Bat();
		System.out.println(bat1.attackTown());
		System.out.println(bat1.eathumans());
		System.out.println(bat1.fly());
		System.out.println(bat1.attackTown());
		System.out.println(bat1.fly());
		System.out.println(bat1.attackTown());
		System.out.println(bat1.eathumans());
		System.out.println("Bats total energy: " + bat1.displayEnergy());

	}
}
