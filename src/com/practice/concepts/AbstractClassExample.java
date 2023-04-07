package com.practice.concepts;

abstract class Vehicle {
	abstract void drive();
}

class BMW extends Vehicle {

	@Override
	void drive() {
		System.out.println("Drive : BMW");
	}

}

public class AbstractClassExample {

	public static void main(String[] args) {

	}

}
