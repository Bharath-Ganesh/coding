package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 * <p>
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * <p>
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * <p>
 * <p>
 * * Input: nums = [0,1,0,1,0,1,1,0,0,1,1,1]
 * * Output: 10
 * * Explanation: [0,1,0,1,0,1,1,0,0,1] is a longest contiguous subarray with equal number of 0 and 1.
 */
public class _062_ContigousArray {

    public static void main(String[] args) {
        int nums[] = {0,1,0,1,0,1,1,0,0,1};
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {

        Map<Integer,Integer> map=new HashMap();
        int maxLength=-1;
        int sum=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sum+=-1;
            }else{
                sum+=1;
            }
            if(map.containsKey(sum)){
                int length=i-map.get(sum);
                maxLength=Math.max(length,maxLength);
            }else{
                map.put(sum,i);
            }
        }
        return maxLength;
    }
}
