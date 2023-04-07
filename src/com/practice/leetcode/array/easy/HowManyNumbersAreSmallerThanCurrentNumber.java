package com.practice.leetcode.array.easy;

import java.util.Arrays;


/**
 * Given the array nums, for each nums[i] find out how many numbers in the array
 * are smaller than it. That is, for each nums[i] you have to count the number
 * of valid j's such that j != i and nums[j] < nums[i].
 * 
 * Return the answer in an array.
 * 
 * Input: nums = [8,1,2,2,3] Output: [4,0,1,1,3] Explanation: For nums[0]=8
 * there exist four smaller numbers than it (1, 2, 2 and 3). For nums[1]=1 does
 * not exist any smaller number than it. For nums[2]=2 there exist one smaller
 * number than it (1). For nums[3]=2 there exist one smaller number than it (1).
 * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 *
 *
 * 2 <= nums.length <= 500 0 <= nums[i] <= 100
 */
public class HowManyNumbersAreSmallerThanCurrentNumber {

	public static void main(String[] args) {

		int[] nums = { 8, 1, 2, 2, 3 };
		System.out.println(Arrays.toString(smallerNumbersThanCurrentLeetcode(nums)));

	}

	/**
	 * Mysolution
	 */
	public static int[] smallerNumbersThanCurrent(int[] nums) {
		int[] res = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			int count = 1;
			for (int j = 0; j < nums.length; j++) {
				if (i != j && nums[i] > nums[j]) {
					res[i] = count++;
				}
			}
		}
		return res;
	}

	public static int[] smallerNumbersThanCurrentLeetcode(int[] nums) {
		int[] numberOfOccurenceOfGivenNumsInArray=new int[101];
		int[] countOfNumbersLessThanAGivenNum=new int[101];
		
		for(int i=0;i<nums.length;i++) {
			numberOfOccurenceOfGivenNumsInArray[nums[i]]+=1;
		}
		
		for(int i=1;i<101;i++) {
			countOfNumbersLessThanAGivenNum[i]=countOfNumbersLessThanAGivenNum[i-1]+numberOfOccurenceOfGivenNumsInArray[i-1];
		}
		
		for(int i=0 ;i<nums.length;i++) {
			nums[i]=countOfNumbersLessThanAGivenNum[nums[i]];
		}
		return nums;
	}

}
