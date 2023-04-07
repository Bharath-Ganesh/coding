package com.practice.pepcoding.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string. You have to find all the combinations of the string
 * 
 */
public class PerumutationOfString {

	public static void main(String[] args) {

		String inputString = "abc";
		List<String> permutationStrings = stringPerumation(inputString);
		for (String element : permutationStrings) {
			System.out.println(element);
		}

	}

	private static List<String> stringPerumation(String inputString) {

		List<String> permutationStrings = new ArrayList<>();
		int fact = findFactorial(inputString.length());
		System.out.println(fact);
		int length = inputString.length();
		for (int i = 0; i < fact; i++) {
			StringBuffer duplicateString = new StringBuffer(inputString);
			int temp = i;
			String word = "";
			for (int j = 0; j < length; j++) {
				int quotient = temp / length;
				int remainder = temp % length;
				word += duplicateString.charAt(remainder);
				duplicateString.deleteCharAt(remainder);
				temp = quotient;
			}
			permutationStrings.add(word);
		}
		return permutationStrings;
	}

	private static int findFactorial(int length) {

		if (length != 1) {
			return length * findFactorial(--length);
		} else {
			return 1;
		}
	}

}

//abc

//it can be arranged in n! => 6
//length of string =3 
//
//0,1,2,3,4,5
//
//abc=> 0,1,2
//
//0
//0/3-> q->0; r->0 => a
//0/3-> q->0; r->0 => b
//0/3-> q->0; r->0 => c
//
//1
//1/3-> q->0; r->1 => b
//0/3-> q->0; r->0 => a
//0/3-> q->0; r->0 => c
//
//2
//2/3-> q->0; r->2 => c
//0/3-> q->0; r->0 => a
//0/3-> q->0; r->0 => b
//
//3
//3/3-> q->1; r->0 => a
//1/3-> q->0; r->1 => c
//0/3-> q->0; r->0 => b
//
//4
//4/3-> q->1; r->1 => b
//1/3-> q->0; r->1 => c
//0/3-> q->0; r->0 => a
//
//5
//5/3-> q->1; r->2 => c
//1/3-> q->0; r->1 => b
//0/3-> q->0; r->0 => a