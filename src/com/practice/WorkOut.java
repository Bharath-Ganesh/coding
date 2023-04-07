package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Two children, Lily and Ron, want to share a chocolate bar. Each of the
 * squares has an integer on it.
 * 
 * Lily decides to share a contiguous segment of the bar selected such that:
 * 
 * The length of the segment matches Ron's birth month, and, The sum of the
 * integers on the squares is equal to his birth day. Determine how many ways
 * she can divide the chocolate.
 * 
 * birthday has the following parameter(s):
 * 
 * int arr[n]: the numbers on each of the squares of chocolate
 * 
 * int d: Ron's birth day
 * 
 * int m: Ron's birth month
 * 
 * input arr[] = 1 2 1 3 2; d=3 m=2
 * 
 * output : 2
 * 
 * input arr2[]=2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1 ; d=18 ;
 * m=17;
 *
 */
public class WorkOut {

	public static void main(String[] args) {

		List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 2));
		System.out.println(birthdayHackerRank(input, 3, 2));

	}

	// sliding window approach
	private static int birthdayHackerRank(List<Integer> arr, int day, int month) {
		int numberOfDivision = 0;

		// segment length is month ; hence that can be treated as the window
		int birthdaySum = 0;
		for (int i = 0; i < month - 1; i++) {
			
			// iteration from 0-> window-1
			birthdaySum += arr.get(i);
		}

		for (int i = month - 1; i < arr.size(); i++) {
			
			// last element in the window 
			birthdaySum += arr.get(i);
			if (birthdaySum == day)
				numberOfDivision++;
			// removing the first element
			birthdaySum -= arr.get(i - (month - 1));
		}

		return numberOfDivision;
	}

}
