package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 *
 * Integer arr[]= {0,0,1,0,1,0,1,1,0,0,1,1,1};
 * output
 * 12
 * {0,0,1,0,1,0,1,1,0,0,1,1}
 */
public class FindLongestContiguousSubarray_28 {

    public static void main(String[] args) {
        Integer arr[]= {0,0,1,0,1,0,1,1,0,0,1,1,1};
        int length=findLongestContiguousSubarray(arr);
        System.out.println(length);
    }

    private static int findLongestContiguousSubarray(Integer[] arr) {
        int maxLength=0;
        //for storing index and sum
        Map<Integer,Integer> map = new HashMap<>();
        int sum=0;
        //first index
        map.put(sum,-1);

        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                sum+=-1;
            }else{
                sum+=arr[i];
            }
            if(map.containsKey(sum)){
                maxLength = maxLength < (i - map.get(sum))? (i - map.get(sum)):maxLength;
            }else{
                //The basic idea is that if we treat 0 as -1 , if at any two points in the array, s1 and s2, sums are equal, then sub-array between them
                //will be having equal zeroes and ones, s2-s1=0
                map.put(sum,i);
            }
        }

        return maxLength;
    }
}
