package com.leetcode.searchandsort;


import java.util.Arrays;

class Partition {
    private int left;
    private int right;


    Partition(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }
}

/**
 * Three-way Partitioning
 * Bentley-McIlroy's Approach
 */
public class _013_PartitioningAndSortingArraysWithDuplicateKeys {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 7, 7, 7, 4, 5, 7, 9, 0};
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }



    /*
       Three-way partitioning
    */
    public static void quicksort(int[] input, int begin, int end) {
        if (end <= begin)
            return;

        Partition middlePartition = partition(input, begin, end);
        quicksort(input, begin, middlePartition.getLeft() - 1);
        quicksort(input, middlePartition.getRight() + 1, end);
    }


    public static Partition partition(int[] input, int begin, int end) {
        int lt = begin, current = begin, gt = end;
        int partitioningValue = input[begin];

        while (current <= gt) {
            int compareCurrent = compare(input[current], partitioningValue);
            switch (compareCurrent) {
                case -1:
                    swap(input, current++, lt++);
                    break;
                case 0:
                    current++;
                    break;
                case 1:
                    swap(input, current, gt--);
                    break;
            }
        }
        return new Partition(lt, gt);
    }

    public static int compare(int num1, int num2) {
        if (num1 > num2)
            return 1;
        else if (num1 < num2)
            return -1;
        else
            return 0;
    }

    public static void swap(int[] array, int position1, int position2) {
        if (position1 != position2) {
            int temp = array[position1];
            array[position1] = array[position2];
            array[position2] = temp;
        }
    }
}
