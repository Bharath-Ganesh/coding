package com.practice.uiuc.array;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithSumK {

    public static void main(String[] args) {

        SubArrayWithSumK obj = new SubArrayWithSumK();
        int[] nums = {2, 5, -3, -4, 0, 7};
        System.out.println(obj.subarraySum(nums, 7));
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int subArray=0;
        for(int num : nums){
            sum+=num;
            if(map.containsKey(sum-k)){
                subArray+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return subArray;

    }
}
