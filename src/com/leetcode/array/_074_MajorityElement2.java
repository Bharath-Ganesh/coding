package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 229. Majority Element II
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * <p>
 * Input: nums = [3,2,3]
 * Output: [3]
 * <p>
 * Input: nums = [1]
 * Output: [1]
 */
public class _074_MajorityElement2 {

    public static void main(String[] args) {
        int[] nums={3,2,3,2,2};
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        if(nums.length==1){
            List<Integer> res=new ArrayList<>();
            res.add(nums[0]);
            return res;
        }
        int element1=Integer.MIN_VALUE;
        int element2=Integer.MIN_VALUE;
        int counter1=0;
        int counter2=0;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if(num==element1){
                counter1++;
            }else if(num==element2){
                counter2++;
            }else if(counter1==0){
                counter1=1;
                element1=num;
            }else if(counter2==0){
                counter2=1;
                element2=num;
            }else{
                counter1--;
                counter2--;
            }
        }

        return isMajority(nums,element1,element2);

    }

    private static List<Integer> isMajority(int[] nums,int element1,int element2){
        int counter1=0;
        int counter2=0;
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            counter1=element1==nums[i]?counter1+1:counter1;
            counter2=element2==nums[i]?counter2+1:counter2;
        }

        if(counter1>(nums.length/3)){
            res.add(element1);
        }


        if(counter2>(nums.length/3)){
            res.add(element2);
        }
        return res;
    }

}
