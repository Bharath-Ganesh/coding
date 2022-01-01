package com.leetcode.searchandsort;

/**
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
 * <p>
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 */
public class _019_CountNegativeNumbersSortedMatrix {

    public static void main(String[] args) {
        int[][] grid={{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(grid));
    }

    public static int countNegatives(int[][] grid) {

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] arr = grid[i];
            int index = binarySearch(arr);
            if (index != arr.length) {
                count += (arr.length - index);
            }
        }
        return count;
    }

    public static int binarySearch(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int num = (high - low) / 2 + low;
            if (arr[num] >= 0) {
                low = num + 1;
            } else {
                high = num - 1;
            }
        }
        return low;
    }
}
