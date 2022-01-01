package com.practice.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Exercise1Java7 {

	public static void main(String[] args) {

		List<Person> personList = Arrays.asList(new Person("Charles", "Dickens", 24), new Person("Lewis", "Cyndey", 24),
				new Person("Thomas", "Carol", 24), new Person("Charley", "Bronte", 24),
				new Person("Matthew", "Arnold", 24));

		/**
		 * JAVA 7
		 */
		// Step 1: sort list by last name
		Collections.sort(personList, new Comparator<Person>(

		) {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});

		// Step 2: Create a method that print all elements in the list
		printAllPeople(personList);

		// Step 3 : Create a method that prints all people that have last name beginning
		// with C
		printLastNameBeginningWithC(personList);

		System.out.println("\nLast name beginning with C");
		printConditionally(personList, new Condition() {
			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("C");
			};
		});

		System.out.println("\nFirst name beginning with C");
		printConditionally(personList, new Condition() {
			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("C");
			}
		});

	}

	private static void printConditionally(List<Person> personList, Condition condition) {
		personList.stream().filter(person -> condition.test(person)).forEach(p -> System.out.println(p.getLastName()));
	}

	private static void printLastNameBeginningWithC(List<Person> personList) {
		personList.stream().filter(person -> person.getLastName().startsWith("C"))
				.forEach(p -> System.out.println(p.getLastName()));

		personList.stream().filter(person -> person.getLastName().startsWith("C")).forEach(new Consumer<Person>() {

			@Override
			public void accept(Person p) {
				System.out.println(p.getLastName());

			}
		});

	}

	private static void printAllPeople(List<Person> personList) {
		personList.stream().forEach(person -> System.out.println(person.getLastName()));

	}
}

interface Condition {
	boolean test(Person p);
}