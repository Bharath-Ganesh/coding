package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class _009_Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

//    public static List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        subsets(nums, res, new ArrayList(), 0);
//        return res;
//    }
//
//    private static void subsets(int[] nums, List<List<Integer>> res, List<Integer> curr, int index) {
//        if (index == nums.length) {
//            res.add(new ArrayList(curr));
//            return;
//        }
//
//        curr.add(nums[index]);
//        subsets(nums, res, curr, index + 1);
//
//        curr.remove(curr.size() - 1);
//        subsets(nums, res, curr, index + 1);
//    }


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        int index=0;
        subsets(res,curr,index,nums);
        Arrays.sort(nums);
        return res;

    }


    public static void subsets(List<List<Integer>> res,List<Integer> curr,int index,int[] nums) {

        if(index==nums.length){
            res.add(new ArrayList(curr));
            return;
        }

        curr.add(nums[index]);
        subsets(res,curr,index+1,nums);
        curr.remove(curr.size()-1);
        subsets(res,curr,index,nums);

    }
}
