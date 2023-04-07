package com.practice.lambda;

import java.util.Arrays;
import java.util.function.BiConsumer;

public class Exercise3ExceptionHandling {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 8, 3, 10 };
		int key = 2;
		process(arr, key, (num1, num2) -> System.out.printf("%d ", (num1 + num2)));

	}

	public static void process(int[] arr, int key, BiConsumer<Integer, Integer> consumer) {
		Arrays.stream(arr).forEach(element -> consumer.accept(element, key));
	}

}
