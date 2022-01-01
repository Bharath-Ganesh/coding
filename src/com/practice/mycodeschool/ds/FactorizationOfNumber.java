package com.practice.mycodeschool.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FactorizationOfNumber {

	public static void main(String[] args) {
		Integer num = 24;
		System.out.println(primeFactorizationOfNumberUsingLoops(num));
		System.out.println(primeFactorizationOfNumber(num));
	}

	private static Integer findingDivisor(Integer num) {
		Integer divisor = -1;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				divisor = i;
				break;
			}
		}
		return divisor;
	}

	private static List<Integer> primeFactorizationOfNumber(Integer num) {
		List<Integer> primeFactors = new ArrayList<>();

		Integer div = num;
		while (true) {
			if (div == 1) {
				break;
			}
			div = findingDivisor(num);
			if (div == -1) {
				primeFactors.add(num);
				break;
			}
			primeFactors.add(div);
			num = num / div;

		}
		return primeFactors;
	}

	private static List<Integer> primeFactorizationOfNumberUsingLoops(Integer num) {
		List<Integer> primeFactors = new ArrayList<>();
		int ocn = num;
		for (int i = 2; i <= Math.sqrt(ocn); i++) {
			while (num % i == 0 && num > 0) {
				primeFactors.add(i);
				num = num / i;
			}
		}
		return primeFactors;
	}

	private static List<Integer> factorsOfANumber(Integer num) {
		List<Integer> factors = new ArrayList<>();
		factors.add(1);

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				factors.add(i);
				if (i != (num / i)) {
					factors.add(num / i);
				}
			}
		}
		factors.add(num);
		factors = factors.stream().sorted().collect(Collectors.toList());
		return factors;
	}
}
