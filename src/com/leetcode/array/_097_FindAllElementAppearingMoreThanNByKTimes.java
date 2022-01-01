package com.leetcode.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/
 * Given an array of size n, find all elements in array that appear more than n/k times.
 * <p>
 * input arrays is {3, 1, 2, 2, 1, 2, 3, 3} and k is 4, then the output should be [2, 3].
 * Note that size of array is 8 (or n = 8), so we need to find all elements that appear more than 2 (or 8/4) times.
 * There are two elements that appear more than two times, 2 and 3.
 * <p>
 * Input
 * int[] arr={3, 1, 2, 2, 2, 1, 4, 3, 3};
 * int k=4;
 * <p>
 * Output
 * [2, 3].
 */

class Pair {
    int element;
    int count;

    Pair() {
        this.element = 0;
        this.count = 0;
    }
}

public class _097_FindAllElementAppearingMoreThanNByKTimes {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 2, 2, 1, 4, 3, 3};
        int k = 4;
        System.out.println(moreThanNdK(arr, arr.length, k));
    }

    static List<Integer> moreThanNdK(int arr[], int n, int k) {
        Pair[] pairs = new Pair[k - 1];
        for (int i = 0; i < pairs.length; i++) {
            Pair pair = new Pair();
            pairs[i] = pair;
        }
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            int j;
            for (j = 0; j < pairs.length; j++) {
                if (pairs[j].element == num) {
                    pairs[j].count++;
                    break;
                }
            }
            //The current element is not present in the pairs array
            if (j == pairs.length) {
                for (j = 0; j < pairs.length; j++) {
                    if (pairs[j].count == 0) {
                        pairs[j].element = num;
                        pairs[j].count++;
                        break;
                    }
                }

                //now the pairs array is full now we have to decrease the count of all the element by one
                if (j == pairs.length) {
                    for (j = 0; j < pairs.length; j++) {
                        pairs[j].count--;
                    }
                }
            }
        }
        List<Integer> majority = isMajority(pairs, arr, k);
        return majority;
    }

    private static List<Integer> isMajority(Pair[] pairs, int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        k = arr.length / k;

        for (int i = 0; i < pairs.length; i++) {
            int element = pairs[i].element;
            int counter = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == element) {
                    counter++;
                    if (counter > k) {
                        res.add(element);
                        break;
                    }
                }

            }
        }
        return res;
    }

}
