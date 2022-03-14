package com.leetcode.array;


import java.util.ArrayList;
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
        int[] arr = {3,2,3,2,2 };
        int k = 2;

        System.out.println(moreThanNdK(arr, arr.length, k));
    }

    static List<Integer> moreThanNdK(int arr[], int n, int k) {

        Pair[] pairs = new Pair[k - 1];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair();
        }

        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            // If the element is already present in the list
            int potentialCandidate;
            for (potentialCandidate = 0; potentialCandidate < pairs.length; potentialCandidate++) {
                if (number == pairs[potentialCandidate].element) {
                    pairs[potentialCandidate].count += 1;
                    break;
                }
            }

            if (potentialCandidate == pairs.length) {
                int l;
                for (l = 0; l < pairs.length; l++) {
                    if (pairs[l].count == 0) {
                        pairs[l].element = number;
                        pairs[l].count = 1;
                        break;
                    }
                }

                if (l == pairs.length) {
                    for (int j = 0; j < pairs.length; j++) {
                        pairs[j].count -= 1;
                    }
                }
            }
        }
        return isMajority(pairs, arr, k);

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
