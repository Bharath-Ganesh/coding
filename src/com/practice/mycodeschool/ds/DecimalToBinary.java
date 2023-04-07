package com.practice.mycodeschool.ds;

public class DecimalToBinary {

	public static String decimalToBinary(String number) {

		String binaryNumber = "";
		String reversebinaryNumber = "";
		Integer binaryNumberInt = Integer.parseInt(number);

		int quotient = binaryNumberInt;
		int remainder = 0;
		while (remainder < quotient) {

			remainder = quotient % 2;
			quotient = quotient / 2;
			binaryNumber += remainder;
		}

		for (int i = binaryNumber.length() - 1; i >= 0; i--) {
			reversebinaryNumber += binaryNumber.charAt(i);
		}

		return reversebinaryNumber;
	}

	public static void main(String[] args) {
		String num=decimalToBinary("125");
		System.out.println(num);
	}

}
