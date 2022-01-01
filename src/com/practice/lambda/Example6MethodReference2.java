package com.practice.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Example6MethodReference2 {
	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(new Person("Charles", "Dickens", 24), new Person("Lewis", "Cyndey", 24),
				new Person("Thomas", "Carol", 24), new Person("Charley", "Bronte", 24),
				new Person("Matthew", "Arnold", 24));

		//System.out is the instance
		printConditionally(personList, p -> true, System.out::println); //p->method(p)

	}

	// predicate functional interface has a default method test with boolean
	// consumer FI has a default method which accept an input and void return
	private static void printConditionally(List<Person> personList, Predicate<Person> predicate,
			Consumer<Person> consumer) {
		for (Person person : personList) {
			// filter condition
			if (predicate.test(person)) {
				// what needs to be done on the filtered
				consumer.accept(person);
			}
		}
	}

}
