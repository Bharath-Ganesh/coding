package com.leetcode.recursion;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations
 * in candidates where the candidate numbers sum to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note: The solution set must not contain duplicate combinations.
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
public class  _007_CombinationSum2 {

    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        System.out.println(combinationSum2(candidates, target));
    }

//    public static List<List<Integer>> combinationSum22(int[] arr, int sum) {
//
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> curr = new ArrayList<>();
//        int index = 0;
//        Arrays.sort(arr);
//        combinationSum2(arr, res, curr, sum, index);
//        return res;
//
//    }
//
//    private static void combinationSum22(int[] arr, List<List<Integer>> res, List<Integer> curr, int sum, int index) {
//
//        if (sum == 0) {
//            res.add(new ArrayList(curr));
//            return;
//        }
//
//        // pick at the index
//        for (int i = index; i < arr.length; i++) {
//            if (arr[i] > sum) {
//                break;
//            }
//            if (i == index || arr[i] != arr[i - 1]) {
//                curr.add(arr[i]);
//                combinationSum2(arr, res, curr, sum - arr[i], i + 1);
//                curr.remove(curr.size() - 1);
//            }
//        }
//    }
//
//
//    public static List<List<Integer>> combinationSum222(int[] candidates, int target) {
//        List<List<Integer>> res=new ArrayList<>();
//        List<Integer> currList=new ArrayList<>();
//        int index=0;
//        Arrays.sort(candidates);
//        combinationSum2(candidates,target,currList,res,index);
//        return res;
//    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> currList=new ArrayList<>();
        int index=0;
        Arrays.sort(candidates);
        combinationSum2(candidates,target,currList,res,index);
        return res;
    }

    public static void combinationSum2(int[] candidates, int target,List<Integer> currList,List<List<Integer>> res,int index) {



        if(index>=candidates.length || target<0){
            return;
        }

        if(target==0){
            res.add(new ArrayList<>(currList));
            return;
        }

        for(int i=index;i<candidates.length;i++){
            if(i==index || candidates[i]!=candidates[i-1]){
                currList.add(candidates[i]);
                combinationSum2(candidates,target-candidates[i],currList,res,i+1);
                currList.remove(currList.size()-1);
            }
        }
    }


}
