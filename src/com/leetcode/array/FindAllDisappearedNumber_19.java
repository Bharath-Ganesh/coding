package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 448. Find All Numbers Disappeared in an Array
 *
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 *
 */
public class FindAllDisappearedNumber_19 {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result=findDisappearedNumbersLeetcode(nums);
        System.out.println(result);

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i]);
            if(nums[index-1]>0){
                nums[index-1]=-nums[index-1];
            }
        }

        List<Integer> result= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }

    /**
     * By (nums[i]-1) % n, we can calculate the original number in the array.
     * For example, [4, 3, 2, 7, 8, 2, 3, 1]
     * if i == 1, nums[i] = 3, nums[i]-1 = 2, we will visit the first 2,
     * after visit this 2 will become 10, since n is 8
     * if i == 2, nums[i] = 10, nums[i]-1 = 9, which is wrong
     * Thus we need 10 % 8 = 2 to calculate the original number to get the index.
     * if i ==2, (nums[i]-1) % n = 1, we can visit correctly
     */
    public static List<Integer> findDisappearedNumbersLeetcode(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i ++) {
            int x=(nums[i]-1) % n;
            nums[(nums[i]-1) % n] += n;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] <= n) res.add(i+1);
        }
        return res;
    }
}


