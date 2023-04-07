package com.practice.mycodeschool.ds;

public class FindLCMandHCF {

	public static void findLCMandHCF(Integer num1, Integer num2) {

		int dividend = num1;
		int divisor = num2;
		int hcf, lcm;

		while (dividend % divisor != 0) {
			int remainder = dividend % divisor;
			dividend = divisor;
			divisor = remainder;
		}

		hcf = divisor;
		lcm = (num1 * num2) / hcf;
		System.out.printf("HCF : %d  ; LCM : %d ", hcf, lcm);
	}

	public static void main(String[] args) {

		int number = 5;
		int number2 = 2;
		findLCMandHCF(number, number2);

	}

}
