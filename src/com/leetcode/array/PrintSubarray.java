package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class PrintSubarray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(printSubarray(nums));
    }

    public static List<List<Integer>> printSubarray(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                List<Integer> currList = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    currList.add(nums[k]);
                }
                list.add(currList);
            }
        }
        return list;
    }
}
