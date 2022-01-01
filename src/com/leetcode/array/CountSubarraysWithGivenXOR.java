package com.leetcode.array;

import java.util.*;

/**
 * Count Subarrays with Given XOR
 */
public class CountSubarraysWithGivenXOR {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4 ,2 ,2 ,6 ,4);
        System.out.println(subarraysXor(list, 6));
    }

    public static int subarraysXor(List<Integer> arr, int x) {
        // Write your code here.
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int xor = 0;
        for (int i = 0; i < arr.size(); i++) {
            int num = arr.get(i);
            xor = (xor ^ num);
            if (xor == x) {
                count += 1;
            }
            int y = (xor ^ x);
            if (map.containsKey(y)) {
                count += map.get(y);
            }
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}
