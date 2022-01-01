package com.practice.leetcode.array.easy;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If
 * reversing x causes the value to go outside the signed 32-bit integer range
 * [-231, 231 - 1], then return 0
 * 
 * Input: x = 123 Output: 321
 * 
 * Input: x = -123 Output: -321
 *
 */
public class ReverseInteger {

	public static void main(String[] args) {
		int num = 1534236469;
		int rev = reverseLeetCode(num);
		System.out.println(rev);
	}

	public static int reverseLeetCode(int num) {

		// we can store the value beyond 32 bit in int
		long reverse = 0;

		while (num != 0) {

			reverse = reverse * 10 + num % 10;
			num = num / 10;
		}

		if (reverse >= Integer.MIN_VALUE && reverse <= Integer.MAX_VALUE) {
			return (int) reverse;
		} else {
			return 0;
		}

	}

	/**
	 * My solution
	 */
	public static int reverse(int x) {

		int reverse = 0;
		int num = x;
		if (num < 0) {
			num *= -1;
		}
		// num > 0 confition : num!=0
		while (num > 0) {
			int remainder = num % 10;
			reverse = reverse * 10 + remainder;
			num = num / 10;
		}
		if (x < 0) {
			return reverse * -1;
		}
		return reverse;

	}

}
