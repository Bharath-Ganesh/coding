package com.practice.lambda;

public class Greeting {

	// inline values String foo="2";

	// Function as values.

	// Here we are passing an instance of the class having the behavior hello
	// greeting
	public void greet(Greeter helloWorldGreeter) {
		helloWorldGreeter.helloGreeting();
	}

	public static void main(String[] args) {
		Greeting greeting = new Greeting();
		// The implementation class is required
		Greeter helloWorldGreeter = new HelloWorldGreeter();

		// the implementation is the lambda expression
		Greeter lambdaGreeter = () -> System.out.println("Hello world!");

		Greeter innerClassGreeting = new Greeter() {
			public void helloGreeting() {
				System.out.println("Hello World! Anonymous inner class");
			}
		};

//		// The implementation class is required
//		helloWorldGreeter.helloGreeting();
//
//		// the implementation is the lambda expression
//		lambdaGreeter.helloGreeting();

		innerClassGreeting.helloGreeting();

		greeting.greet(lambdaGreeter);
		greeting.greet(innerClassGreeting);

	}

}
