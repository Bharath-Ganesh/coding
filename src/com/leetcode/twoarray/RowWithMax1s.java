package com.leetcode.twoarray;

public class RowWithMax1s {
    public static void main(String[] args) {
        RowWithMax1s obj = new RowWithMax1s();
        int[][] arr = { {0, 0, 0, 0, 0,0,0,0}};
        System.out.println(obj.rowWithMax1s(arr, arr.length, arr[0].length));
    }

    public int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        if (arr[0][0] == 1) {
            return 0;
        }
        int minRow = -1;
        int minCol = findFirstOneIndex(arr[0], 0, m - 1);
        if (minCol != m) {
            minRow = 0;
        }
        if (minCol == 0) {
            return 0;
        }
        for (int i = 1; i < n; i++) {
            int col = findFirstOneIndex(arr[i], 0, minCol - 1);
            if (col == 0) {
                return i;
            }
            if (col < minCol) {
                minRow = i;
                minCol = col;
            }
        }
        return minRow;
    }

    private int findFirstOneIndex(int[] matrix, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid] == 1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
