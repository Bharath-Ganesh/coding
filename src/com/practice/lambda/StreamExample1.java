package com.practice.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample1 {

	public static void main(String[] args) {

		// all elements
		IntStream.range(1, 10).forEach(System.out::print);
		System.out.println();

		// all elements except numbers from 1->5
		IntStream.range(1, 10).skip(5).forEach(x -> System.out.printf("%d ", x));

		// all elements sum
		System.out.println(IntStream.range(1, 10).sum());

		// Stream of sorted and findFirst
		List<String> names = Arrays.asList("Bharath", "Radhika", "Gayathri", "Jayasankar", "Ganesh", "Amma");
		names.stream().sorted().findFirst().ifPresent(System.out::println);

		// Average of sqaures of an int array
		Arrays.stream(new int[] { 2, 4, 6, 8, 10 }).map(x -> x * x).average().ifPresent(System.out::println);

		// People name starting with a/A
		List<String> people = Arrays.asList("Bharath", "Radhika", "gayathri", "Jayasankar", "Ganesh", "amma", "ashok",
				"Arjun", "Ammumma", "Raj", "Priya", "Anup", "Nithya", "Rajeev", "ram", "Renjith");
		people.stream().map(x -> x.toLowerCase()).filter(x -> x.startsWith("a"))
				.forEach(x -> System.out.printf("%s ", x));
		System.out.println();

		// Create a new list with people name starting with a
		List<String> peopleNameStartingWithR = people.stream().map(x -> x.toLowerCase()).filter(x -> x.startsWith("r"))
				.collect(Collectors.toList());
		peopleNameStartingWithR.stream().forEach(x -> System.out.printf("%s ", x));
		System.out.println();

		// Reduction sum
		double total = Stream.of(7.2, 12.9, 23.6).reduce(0.0, (Double a, Double b) -> a + b);
		System.out.println(total);

	}

}
