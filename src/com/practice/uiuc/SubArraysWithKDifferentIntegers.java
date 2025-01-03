package com.practice.uiuc;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithKDifferentIntegers {

    public static void main(String[] args) {
        SubArraysWithKDifferentIntegers obj = new SubArraysWithKDifferentIntegers();
        int [] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(obj.subarraysWithKDistinct(nums, k));
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;
        int res = 0;

        int left = 0, right = 0;
        int n = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();

        while(right < n) {
            int count = countMap.getOrDefault(nums[right],0);
            countMap.put(nums[right], ++count);

            while (countMap.size() > goal){
                int freq = countMap.get(nums[left]);
                if(freq == 1){
                    countMap.remove(nums[left]);
                }else {
                    countMap.put(nums[left], freq - 1);
                }
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }
}
