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
        int[] nums={3,2,3};
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {

        //here the first element is assigned to num1
        Integer element1=nums[0];
        // the second element could be any value which is not equal to num1
        Integer element2=element1+1;
        int counter1=1;
        int counter2=0;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if(element1!=null && num==element1){
                counter1++;
            }else if(element2!=null && num==element2){
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

    private static List<Integer> isMajority(int[] nums,Integer element1,Integer element2){
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
