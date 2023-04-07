package com.practice.lambda;

public class TypeInference {

	public static void main(String[] args) {

		// the interface is detected at runtime
		printLambda((s) -> s.length());

	}

	public static void printLambda(StringLengthLambda s) {
		System.out.println(s.getLength("Hello World"));
	}

	interface StringLengthLambda {
		public int getLength(String s);
	}

}
