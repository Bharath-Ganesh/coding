package com.practice.mycodeschool.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindAllFactorsOfNumber {

	public static void main(String[] args) {
		Integer num = 12;
		System.out.println(findAllFactors(num).stream().sorted().collect(Collectors.toList()));
	}

	private static List<Integer> findAllFactors(Integer num) {
		List<Integer> listIntegers = new ArrayList<>();
		listIntegers.add(1);
		listIntegers.add(num);
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				if (i != num / i) {
					listIntegers.add(num / i);
				}
				listIntegers.add(i);

			}
		}
		return listIntegers;
	}

}
