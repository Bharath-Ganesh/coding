package com.practice.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class StreamExample2 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(88, 2, 4, 5, 6, 7, 8, 9, 10);
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum = sum + list.get(i) * 2;
		}

//		Collections.sort(list, new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				if (o1 < o2) {
//					return -1;
//				}
//				return -1;
//			}
//		});

		Collections.sort(list, (o1, o2) -> o1 < o2 ? 1 : -1);
		list.forEach(x -> System.out.printf("%d ", x));
		System.out.println();
		System.out.println(sum);

		Function<Integer, Integer> fn = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer element) {
				return element * 2;
			}

		};

		BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer sum, Integer element) {
				return sum + element;
			}
		};

		Consumer<Integer> consumer = new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		};

		list.stream().map(fn).reduce(binaryOperator).ifPresent(consumer);

		int sumList = list.stream().map(i -> i * 2).reduce(0, (a, b) -> Integer.sum(a, b)).intValue();
		int sumList2 = list.stream().map(i -> i * 2).reduce(0, Integer::sum).intValue();

		List<Integer> oddList = Arrays.asList(1, 3, 5, 7, 9);
		int div = list.stream().filter(i -> i % 2 == 0).findAny().orElse(-1);
		System.out.println(div);
	}

}
