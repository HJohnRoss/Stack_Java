package com.day3.week1;

public class CarTest {

	public static void main(String[] args) {
		Driver driver1 = new Driver();
		driver1.driving();
		driver1.driving();
		driver1.refuel();
		driver1.driving();
		driver1.refuel();
		driver1.driving();
		driver1.booster();
		driver1.refuel();
		System.out.println(driver1.remainingGas());
	}

}
