package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 414. Third Maximum Number
 * Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
 * <p>
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2.
 * The third distinct maximum is 1.
 */
public class ThirdMaximum_18 {

    public static void main(String[] args) {
        int[] nums={5,6,4,4,3,1,2};
        System.out.println(thirdMax((nums)));
    }

    public static int thirdMax(int[] nums) {
        Integer max=null;
        Integer second_max=null;
        Integer third_max=null;

        for(Integer num : nums){

            if(num.equals(max) || num.equals(second_max) || num.equals(third_max)){
                continue;
            }

            if(max==null || num>max){
                third_max=second_max;
                second_max=max;
                max=num;
            }else  if(second_max==null || num>second_max){
                third_max=second_max;
                second_max=num;
            }else  if(third_max==null || num>third_max){
                third_max=num;
            }
        }

        if(third_max==null){
            return max;
        }
        return third_max;
    }


}
