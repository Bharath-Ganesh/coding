package com.practice.hacerrank;

/*
 * Your local library needs your help! Given the expected and actual return dates for a library book, create a program that calculates the fine (if any). The fee structure is as follows:

1.If the book is returned on or before the expected return date, no fine will be charged (i.e.: fine=0)
2.If the book is returned after the expected return day but still within the same calendar month and year as the expected return date, .
	fine = 15 * number of days late
3.If the book is returned after the expected return month but still within the same calendar year as the expected return date, the .
	fine = 500 * number of months late
4.If the book is returned after the calendar year in which it was expected, there is a fixed fine of .
	fine = 10 000
Charges are based only on the least precise measure of lateness. 
For example, whether a book is due January 1, 2017 or December 31, 2017, if it is returned January 1, 2018, that is a year 
late and the fine would be 10000.

Complete the libraryFine function in the editor below.

libraryFine has the following parameter(s):

d1, m1, y1: returned date day, month and year, each an integer
d2, m2, y2: due date day, month and year, each an integer
 */
public class LibraryFine {

	public static void main(String[] args) {
		int fine = libraryFine(2, 7, 2015, 1, 2, 2014);
		System.out.println(fine);

	}

	public static int libraryFine(int rtd1, int rtm1, int rty1, int d2, int m2, int y2) {

		int fine = 0;
		if (rty1 > y2) {
			fine = 1000;
		} else if (rty1 == y2) {
			if (rtm1 > m2) {
				fine = 500 * (rtm1 - m2);
			} else if (rtm1 == m2) {
				if (rtd1 > d2) {
					fine = 15 * (rtd1 - d2);
				}
			}
		}

		return fine;
	}

}
