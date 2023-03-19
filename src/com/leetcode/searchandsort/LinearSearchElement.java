package com.leetcode.searchandsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinearSearchElement {

    public static void main(String[] args) {
        LinearSearchElement obj = new LinearSearchElement();
        int[] arr = {6, 1, 4, 48, 42, 5, 6};
        //List<Integer> integerList = obj.linearSearch(arr, 4, 0);
        //System.out.println(integerList);
        //obj.starPattern(0, 4);
        obj.bubbleSort(arr.length, 1, arr);
        Arrays.stream(arr).forEach(x ->System.out.print(x + " "));


    }

    private List<Integer> linearSearch(int[] arr, int target, int index) {

        if (index == arr.length) return new ArrayList<>();

        List<Integer> integers = linearSearch(arr, target, index + 1);
        if (arr[index] == target)
            integers.add(index);
        return integers;
    }

    private void starPattern(int row, int col) {

        if (row == col) {
            return;
        }
        starPattern(row + 1, col);
        for (int i = row; i < col; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    private void bubbleSort(int row, int col, int[] arr) {

        if (row == 0) {
            return;
        }

        if (row == col) {
            bubbleSort(row - 1, 1, arr);
        } else {
            if (arr[col - 1] > arr[col]) {
                int temp = arr[col - 1];
                arr[col - 1] = arr[col];
                arr[col] = temp;
            }
            bubbleSort(row, col + 1, arr);
        }
    }
}
