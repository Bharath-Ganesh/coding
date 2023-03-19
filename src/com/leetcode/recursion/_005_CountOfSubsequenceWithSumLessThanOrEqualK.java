package com.leetcode.recursion;

/**
 * https://www.geeksforgeeks.org/count-of-subsequences-in-an-array-with-sum-less-than-or-equal-to-x/
 * <p>
 * Given an integer array arr[] of size N and an integer X, the task is to count the number of subsequences in that array
 * such that its sum is less than or equal to X.
 * Note: 1 <= N <= 1000 and 1 <= X <= 1000, where N is the size of the array.
 * <p>
 * Input : arr[] = {84, 87, 73}, X = 100
 * Output : 3
 * Explanation: The three subsequences with sum less than or equal to 100 are {84}, {87} and {73}.
 * <p>
 * Input : arr[] = {25, 13, 40}, X = 50
 * Output : 4
 * Explanation: The four subsequences with sum less than or equal to 50 are {25}, {13}, {40} and {25, 13}.
 */
public class _005_CountOfSubsequenceWithSumLessThanOrEqualK {

    public static void main(String[] args) {
        int arr[] = {25, 13, 40}, sum = 50;
        System.out.println(countOfSubsequenceWithSumLessThanOrEqualK(arr, sum));
    }

    private static int countOfSubsequenceWithSumLessThanOrEqualK(int[] arr, int sum) {
        int index = 0;
        int currSum = 0;
        // -1 is to treat for empty subsequence
        return countOfSubsequenceWithSumLessThanOrEqualK(arr, sum, currSum, index) - 1;
    }

    private static int countOfSubsequenceWithSumLessThanOrEqualK(int[] arr, int sum, int currSum, int index) {

        if (index == arr.length) {
            if (sum >= currSum) {
                return 1;
            }
            return 0;
        }
        int left=countOfSubsequenceWithSumLessThanOrEqualK(arr,sum,currSum+arr[index],index+1);
        int right=countOfSubsequenceWithSumLessThanOrEqualK(arr,sum,currSum,index+1);
        return left+right;
    }


}
