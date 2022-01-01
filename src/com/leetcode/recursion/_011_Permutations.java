package com.leetcode.recursion;

import java.util.*;

/**
 * https://leetcode.com/problems/permutations/
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 */
public class _011_Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
       // System.out.println(permuteExtraSpace(nums));
        System.out.println(permute(nums));
    }


//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res=new ArrayList<>();
//        Set<Integer> set=new HashSet<>();
//        permute(nums,res,set,new ArrayList<>());
//        return res;
//    }
//
//
//    public static void permute(int[] nums, List<List<Integer>> res, Set<Integer> set, List<Integer> currList) {
//        if(currList.size()==nums.length){
//            res.add(new ArrayList<>(currList));
//            return;
//        }
//
//        for(int i=0;i<nums.length;i++){
//            if(set.add(nums[i])){
//                currList.add(nums[i]);
//                permute(nums,res,set,currList);
//                set.remove(nums[i]);
//                currList.remove(currList.size()-1);
//            }
//        }
//    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        int index = 0;
        permute(nums, res, index);
        return res;
    }

    private static void permute(int[] nums, List<List<Integer>> res, int index) {
        if (index == nums.length) {
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                curr.add(nums[i]);
            }
            res.add(curr);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            permute(nums, res, index + 1);
            swap(nums, index, i);
        }

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * Using O(N) Extra space
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteExtraSpace(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        boolean isPresent[] = new boolean[nums.length];
        Arrays.fill(isPresent, false);
        permuteExtraSpace(nums, res, isPresent, new ArrayList());
        return res;
    }

    private static void permuteExtraSpace(int[] nums, List<List<Integer>> res, boolean[] isPresent, List<Integer> curr) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isPresent[i]) {
                isPresent[i] = true;
                curr.add(nums[i]);
                permuteExtraSpace(nums, res, isPresent, curr);
                curr.remove(curr.size() - 1);
                isPresent[i] = false;
            }
        }

    }
}
