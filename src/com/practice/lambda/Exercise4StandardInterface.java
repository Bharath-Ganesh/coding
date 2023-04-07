package com.practice.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Exercise4StandardInterface {

	public static void main(String[] args) {

		List<Person> personList = Arrays.asList(new Person("Charles", "Dickens", 24), new Person("Lewis", "Cyndey", 24),
				new Person("Thomas", "Carol", 24), new Person("Charley", "Bronte", 24),
				new Person("Matthew", "Arnold", 24));

		/**
		 * JAVA 8 : LAMBDA
		 */
		// Step 1: sort list by last name
		Collections.sort(personList, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		// Step 2: Create a method that print all elements in the list
		printConditionally(personList, p -> true, p -> System.out.println(p.getLastName()));

		// Step 3 : Create a method that prints all people that have last name beginning
		printConditionally(personList, p -> p.getLastName().startsWith("C"), p -> System.out.println(p.getLastName()));

	}

	// predicate functional interface has a default method test with boolean
	// consumer FI has a default method which accept an input and void return
	private static void printConditionally(List<Person> personList, Predicate<Person> predicate,
			Consumer<Person> consumer) {
		for (Person person : personList) {
			if (predicate.test(person)) {
				consumer.accept(person);
			}
		}
		
		
	}

}
