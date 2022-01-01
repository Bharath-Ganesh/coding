package com.leetcode.searchandsort;

import java.util.*;

/**
 * Ninja bought chocolate consisting of some chunks. The sweetness of each chunk is given in an array ‘ARR’. Ninja has ‘K’ friends,
 * and he wishes to divide the chocolate into 'K' + 1 cut with some consecutive chunks. He wants to divide the chocolate into chunks under
 * the condition that he will take the piece that has the minimum total sweetness.
 * He is very busy doing other stuff. Can you help him to maximize the total sweetness of the part that you will get under the given condition?
 * <p>
 * List<Integer> arr1 = Arrays.asList(1, 2, 2, 1, 2, 2, 1, 2, 2);
 * k=2;
 * <p>
 * List<Integer> arr1 = Arrays.asList(5,6,7,8,9,1,2,3,4);
 * int k = 8;
 */
public class _016_ChocolateDistributionProblem {

    public static void main(String[] args) {
        List<Integer> sweetness = Arrays.asList(1, 2, 2, 1, 2, 2, 1, 2, 2);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(sweetness);
        int k = 2;
        System.out.println(getMaximumSweetness(arr, k));
    }

    public static int getMaximumSweetness(ArrayList<Integer> sweetness, int k) {
        // Write your code here.
        int start = 1;
        int end = 0;
        for (int sweet : sweetness) {
            end = end + sweet;
        }
        k += 1;
        end = end / k;
        int minSweetness = 0;
        while (start <= end) {
            int sweetPos = (end - start) / 2 + start;
            if (isPossible(sweetPos, k, sweetness)) {
                minSweetness = sweetPos;
                start = sweetPos + 1;
            } else {
                end = sweetPos - 1;
            }
        }

        return minSweetness;

    }

    private static boolean isPossible(int totalSweet, int k, ArrayList<Integer> sweetness) {
        int currCuts = 0;
        int currSweet = 0;
        for (int sweet : sweetness) {
            currSweet += sweet;
            if (currSweet >= totalSweet) {
                currCuts += 1;
                currSweet = 0;
            }
        }
        return currCuts >= k;

    }


}
