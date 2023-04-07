package com.leetcode.searchandsort;

public class _015_FindInMountainArray {

    public static void main(String[] args) {
        int[] array = {1, 5, 2};
        int target = 2;
        System.out.println(findInMountainArray(target, array));
    }

    public static int findInMountainArray(int target, int[] arr) {
        int pivotIndex = findPivotIndex(0, arr.length - 1, arr);
        int index = binarySearch(target, 0, pivotIndex, arr, true);
        if (index == -1) {
            index = binarySearch(target, pivotIndex, arr.length - 1, arr, false);
        }
        return index;
    }

    public static int binarySearch(int target, int start, int end, int[] arr, boolean isIncreasing) {

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int element = arr[mid];
            if (element == target) {
                return mid;
            } else if (target > element) {
                if (isIncreasing) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (isIncreasing) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }
        }
        return -1;
    }

    public static int findPivotIndex(int start, int end, int[] arr) {

        while (start < end) {
            int mid = (end - start) / 2 + start;
            int element = arr[mid];
            int nextElement = arr[mid + 1];
            if (element < nextElement) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
