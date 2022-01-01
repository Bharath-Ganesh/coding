package com.practice.lambda;

public class Example5MethodReference {
	public static void main(String[] args) {
		Thread thread = new Thread(() -> printMessage());
		thread.start();

		// method reference === () -> printMessage()
		// When there is no input argument and method accept no parameter
		
		Thread t = new Thread(Example5MethodReference::printMessage);
		// t.start();
	}

	public static void printMessage() {
		System.out.println("Message");
	}

}
