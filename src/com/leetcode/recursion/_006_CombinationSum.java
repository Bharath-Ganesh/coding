package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates
 * where the chosen numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at
 * least one of the chosen numbers is different.
 * <p>
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * <p>
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * <p>
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 */
public class _006_CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        int index = 0;
        combinationSum(candidates, target, currList, res, index);
        return res;

    }


    public static void combinationSum(int[] candidates, int target, List<Integer> currList, List<List<Integer>> res, int index) {


        if (index == candidates.length) {
            if (target == 0) {
                res.add(new ArrayList<>(currList));
            }
            return;
        }
        if (target >= candidates[index]) {
            currList.add(candidates[index]);
            combinationSum(candidates, target - candidates[index], currList, res, index);
            currList.remove(currList.size() - 1);
        }

        combinationSum(candidates, target, currList, res, index + 1);
    }
}
