package com.practice;

/**
 * Lily likes to play games with integers. She has created a new game where she
 * determines the difference between a number and its reverse. For instance,
 * given the number 12, its reverse is 21. Their difference is 9.
 * 
 * The number 120 reversed is 21, and their difference is 99.
 * 
 * She decides to apply her game to decision making. She will look at a numbered
 * range of days and will only go to a movie on a beautiful day.
 * 
 * Given a range of numbered days,[i...j] and a number k, determine the number
 * of days in the range that are beautiful. Beautiful numbers are defined as
 * numbers where |i- reverse(i)| is evenly divisible by k. If a day's value is a
 * beautiful number, it is a beautiful day. Return the number of beautiful days
 * in the range.
 * 
 * Complete the beautifulDays function in the editor below.
 * 
 * beautifulDays has the following parameter(s):
 * 
 * int i: the starting day number int j: the ending day number int k: the
 * divisor
 * 
 * input : 20 23 6
 * 
 * output 2 ;
 */
// 20- 2 =18%6==0 		1
// 21- 12 = 9%6!=0	    0
// 22-22 0%6==0 		1
// 23-32    9%6!=0		0
// total 2

public class BeautifulDaysAtMovie {

	public static void main(String[] args) {
		int count = beautifulDays(20, 23, 6);
		System.out.println(count);
	}

	public static int beautifulDays(int starting_num, int ending_num, int k) {

		int count = 0;
		for (int i = starting_num; i <= ending_num; i++) {

			int temp = i;
			int reverse = 0;
			while (temp > 0) {
				reverse = reverse * 10 + temp % 10;
				temp = temp / 10;
			}
			int diff = Math.abs(reverse - i);
			if (diff % k == 0) {
				count++;
			}
		}
		return count;

	}

}
