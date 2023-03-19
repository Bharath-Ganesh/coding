package com.leetcode.twoarray;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/rotate-a-matrix-by-90-degree-in-clockwise-direction-without-using-any-extra-space/
 */
public class RotateArray90 {

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        rotate90Clockwise(arr);
        Arrays.stream(arr).forEach(x -> System.out.println(Arrays.toString(x)));
        int arr1[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        rotate90AntiClockwise(arr1);
        Arrays.stream(arr1).forEach(x -> System.out.println(Arrays.toString(x)));

    }

    private static void rotate90AntiClockwise(int[][] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }


        for (int i = 0; i < n; i++) {
            int low = 0;
            int high = n - 1;
            while (low < high) {
                int temp = arr[low][i];
                arr[low][i] = arr[high][i];
                arr[high][i] = temp;
                low++;
                high--;
            }
        }
    }

    private static void rotate90Clockwise(int arr[][]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        int low = 0;
        int high = n - 1;
        while (low < high) {
            for (int i = 0; i < n; i++) {
                int temp = arr[i][low];
                arr[i][low] = arr[i][high];
                arr[i][high] = temp;
            }
            low++;
            high--;
        }
    }
}
