package com.practice.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Exercise2Java8 {

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
		printConditionally(personList, p -> true);

		// Step 3 : Create a method that prints all people that have last name beginning
		printConditionally(personList, p -> p.getLastName().startsWith("C"));

	}

	private static void printConditionally(List<Person> personList, ConditionLambda condition) {
		for (Person person : personList) {
			if (condition.test(person)) {
				System.out.println(person.getLastName());
			}
		}
	}

}

interface ConditionLambda {
	boolean test(Person p);
}