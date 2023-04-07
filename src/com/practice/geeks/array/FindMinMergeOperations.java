package com.practice.geeks.array;

/**
 * Find minimum number of merge operations to make an array palindrome
 * 
 * Given an array of positive integers. We need to make the given array a
 * ‘Palindrome’. The only allowed operation is”merging” (of two adjacent
 * elements). Merging two adjacent elements means replacing them with their sum.
 * The task is to find the minimum number of merge operations required to make
 * the given array a ‘Palindrome’. To make any array a palindrome, we can simply
 * apply merge operation n-1 times where n is the size of the array (because a
 * single-element array is always palindromic, similar to single-character
 * string). In that case, the size of array will be reduced to 1. But in this
 * problem, we are asked to do it in the minimum number of operations.
 * 
 * Input : arr[] = {15, 4, 15}
 * 
 * Output : 0 Array is already a palindrome. So we do not need any merge
 * operation.
 * 
 * 
 * Input : arr[] = {1, 4, 5, 1}
 * 
 * Output : 1 We can make given array palindrome with minimum one merging
 * (merging 4 and 5 to make 9)
 * 
 * 
 * Input : arr[] = {11, 14, 2,3 ,15, 11} Output : 3 We need to merge all
 * elements to make a palindrome
 *
 */
public class FindMinMergeOperations {

	public static void main(String[] args) {
		// 11, 14, 2 ,15, 99
		int arr[] = { 15, 4, 15 };
		int operations = findMinMergeOperations(arr);
		System.out.println(operations);

	}

	private static int findMinMergeOperations(int[] arr) {
		int operations = 0;
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			if (arr[left] == arr[right]) {
				left++;
				right--;
			} else if (arr[left] < arr[right]) {
				left++;
				arr[left] += arr[left - 1];
				operations++;
			} else {
				right--;
				arr[right] += arr[right + 1];
				operations++;
			}
		}
		return operations;
	}

}
