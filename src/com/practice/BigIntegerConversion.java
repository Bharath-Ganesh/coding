package com.practice;

import java.math.BigInteger;

/**
 * BigInteger class is used for mathematical operation which involves very big
 * integer calculations that are outside the limit of all available primitive
 * data types.
 *
 * For example factorial of 100 contains 158 digits in it so we can’t store it
 * in any primitive data type available. We can store as large Integer as we
 * want in it. There is no theoretical limit on the upper bound of the range
 * because memory is allocated dynamically but practically as memory is limited
 * you can store a number which has Integer.MAX_VALUE number of bits in it which
 * should be sufficient to store mostly all large values.
 *
 */
public class BigIntegerConversion {

	public static void main(String[] args) {
		String message = appendAndDelete("y", "yu", 2);
		System.out.println(message);
	}

	public static void extraLongFactorials(int n) {

		BigInteger fact = BigInteger.ONE;
		while (n >= 1) {
			fact = fact.multiply(BigInteger.valueOf(n));
			n--;
		}
		System.out.println(fact);

	}

	public static String appendAndDelete(String initialString, String desiredString, int k) {

		String message = "Yes";
		int currPos = 0;
		for (int i = 0; i < initialString.length(); i++) {
			if (i < desiredString.length() && initialString.charAt(i) == desiredString.charAt(i)) {
				currPos = i;
			} else {
				break;
			}

		}

		int charToBeDeleted = initialString.length() - currPos - 1;
		int charToBeInserted = desiredString.length() - currPos - 1;

		System.out.println(charToBeDeleted + charToBeInserted);
		if (charToBeDeleted + charToBeInserted > k) {
			message = "No";
		}

		return message;

	}

}
