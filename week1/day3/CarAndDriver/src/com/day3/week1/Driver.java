package com.day3.week1;

public class Driver extends Car {
	public int driving() {
		gas -= 1;
		return gas;
	}
	
	public int booster() {
		gas -= 3;
		return gas;
	}
	
	public int refuel() {
		gas += 2;
		return gas;
	}
}
