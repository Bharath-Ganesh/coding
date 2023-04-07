package com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNumberKSumPairs {

    public static void main(String[] args) {
        MaxNumberKSumPairs obj = new MaxNumberKSumPairs();
        int nums[] = {1, 2, 3, 4, 3, 1, 3, 4, 3};
        System.out.println(obj.maxOperationsSecond(nums, 6));
    }

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).boxed().forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));

        int operations = 0;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            int key = m.getKey();
            int val = m.getValue();
            if (k % 2 == 0 && k / 2 == key) {
                operations += (val / 2);
                continue;
            }
            if (map.containsKey(k - key) && val > 0 && map.get(k - key) > 0) {
                int first = val;
                int second = map.get(k - key);
                int freq = Math.min(first, second);
                operations += freq;
                map.put(k - key, 0);
                map.put(key, 0);
            }
        }
        return operations;
    }

    public int maxOperationsSecond(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int res = k - nums[i];
            if (map.containsKey(res)) {
                count++;
                if (map.get(res) == 1) {
                    map.remove(res);
                } else {
                    map.put(res, map.get(res) - 1);
                }
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return count;
    }
}
