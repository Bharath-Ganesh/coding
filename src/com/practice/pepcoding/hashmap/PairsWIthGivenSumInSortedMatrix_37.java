package com.practice.pepcoding.hashmap;


import java.util.HashMap;
import java.util.Map;

/**
 * 1. You are given a number N and two sorted matrices(A and B) of N*N dimensions.
 * 2. You are also given a number X.
 * 3. You have to find the count of all valid pairs from matrices whose sum is equal to X.
 * 4. A pair is called valid if one element of the pair is selected from A and the second element is selected from B.
 * <p>
 * Integer[] [] arr1= {{1,2,3},{4,5,6},{7,8,9}};
 * Integer[] [] arr2= {{11,12,13},{14,15,16},{17,18,19}};
 */
public class PairsWIthGivenSumInSortedMatrix_37 {

    public static void main(String[] args) {
        Integer[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Integer[][] arr2 = {{11, 12, 13}, {14, 15, 16}, {17, 18, 19}};
        int sum = 18;
        int count = pairsWIthGivenSumInSortedMatrix(arr1, arr2, sum);
        System.out.println(count);

    }

    private static int pairsWIthGivenSumInSortedMatrix(Integer[][] arr1, Integer[][] arr2, int sum) {
        int count = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                int element = arr1[i][j];
                freqMap.put(element, freqMap.getOrDefault(element, 0) + 1);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int element = arr2[i][j];
                int complementPair = sum - element;
                if (freqMap.containsKey(complementPair)) {
                    count += freqMap.get(complementPair);
                }
            }
        }
        return count;
    }
}
