package com.leetcode.array;

import java.util.*;

/**
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * <p>
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 * <p>
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * <p>
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 */
public class _066_4Sum {

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target=0;
        System.out.println(fourSum(nums,target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i==0 || (i>0 && nums[i-1]!=nums[i])){
                for(int j=i+1;j<nums.length-2;j++){
                    if(j==i+1 || nums[j-1]!=nums[j]){
                        int low=j+1;
                        int high=nums.length-1;
                        int sum=target-(nums[i]+nums[j]);
                        while(low<high){
                            if(nums[low]+nums[high]==sum){

                                result.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                                //duplicates are handled
                                while(low<high && nums[low]==nums[low+1]){
                                    low++;
                                }
                                while(low<high && nums[high-1]==nums[high]){
                                    high--;
                                }
                                low++;
                                high--;
                            }else if(nums[low]+nums[high]>sum){
                                high--;
                            }else{
                                low++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
