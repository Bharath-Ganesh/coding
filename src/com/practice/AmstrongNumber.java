/**
 * 
 */
package com.practice;

public class AmstrongNumber {

	/*
	 * For a given 3 digit number, find whether it is armstrong number or not. An
	 * Armstrong number of three digits is an integer such that the sum of the cubes
	 * of its digits is equal to the number itself. Return "Yes" if it is a
	 * armstrong number else return "No".
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 153;
		int armStrongnumber = number;
		int cube = 0;
		int remainder = 0;
		while (number > 0) {

			remainder = number % 10;
			cube = cube + (remainder * remainder * remainder);
			number = number / 10;
		}

		if (cube == armStrongnumber) {
			System.out.println("Amstrong");

		} else {
			System.out.println("Not an armstrong number");
		}
	}

}
