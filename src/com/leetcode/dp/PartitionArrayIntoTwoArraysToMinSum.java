package com.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartitionArrayIntoTwoArraysToMinSum {

    public static void main(String[] args) {
        PartitionArrayIntoTwoArraysToMinSum obj = new PartitionArrayIntoTwoArraysToMinSum();
        int[] nums = {3, 9, 7, 3};
        int diff = obj.minimumDifference(nums);
        System.out.println(diff);

    }

    public int minimumDifference(int[] nums) {

        int N = nums.length;
        int sum = Arrays.stream(nums).sum();
        Map<Integer, Map<Integer, Boolean>> map = new HashMap<>();

        for (int i = 0; i <= N; i++) {
            Map<Integer, Boolean> booleanMap = map.getOrDefault(i, new HashMap<>());
            booleanMap.put(0, true);
            map.put(i, booleanMap);
        }

        for (int i = 0; i <=N ; i++) {
            Map<Integer, Boolean> booleanMap = map.getOrDefault(i, new HashMap<>());
            booleanMap.put(0, true);
            map.put(i, booleanMap);
        }
        Math.pow(2, 2);
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                Boolean notTake = map.get(i - 1).get(j);
                Boolean take = false;
                if (j >= nums[i - 1]) {
                    take = map.get(i - 1).get(j - nums[i - 1]);
                }
                Map<Integer, Boolean> booleanMap = map.getOrDefault(i, new HashMap<>());
                booleanMap.put(j, take | notTake);
                map.put(i, booleanMap);
            }
        }

        int minSum = Integer.MAX_VALUE;

        for (int target = 0; target <= sum / 2; target++) {
            if (map.get(N).get(target) == true) {
                minSum = Math.min(minSum, Math.abs(sum - 2 * target));
            }
        }
        return minSum;
    }
}
