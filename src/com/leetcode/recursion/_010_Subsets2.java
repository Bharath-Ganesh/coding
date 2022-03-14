package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class _010_Subsets2 {
    public static void main(String[] args) {
        int[] nums={1,2,2,2,3,3};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList());
        subsetsWithDup(nums, res, new ArrayList(), 0);
        return res;
    }


    public static void subsetsWithDup(int[] nums, List<List<Integer>> res, List<Integer> dp, int index) {
        for (int i = index; i < nums.length; i++) {
            if (i == index || nums[i] != nums[i - 1]) {
                dp.add(nums[i]);
                subsetsWithDup(nums, res, dp, i + 1);
                res.add(new ArrayList(dp));
                dp.remove(dp.size() - 1);
            }
        }

    }
}
