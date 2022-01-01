package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the longest sub-array with sum divisible by k.
 *
 * int arr[]= {2,4,8,1,7,3,6,1,9,2,7,3};
 * int k=5;
 */
public class LongestSubarrayWithSumDivByK_26 {

    public static void main(String[] args) {
        int arr[]= {2,4,8,1,7,3,6,1,9,2,7,3};
        int k=5;
        longestSubarrayWithSumDivByK(arr,k);
    }

    private static void longestSubarrayWithSumDivByK(int[] arr, int k) {
        //For storing remainder
        int maxLength=0;
        int maxSum=0;
        int initialPosition=-1;
        int finalPosition=-1;
        Map<Integer,Integer> map = new HashMap<>();
        int sum=0;
        map.put(0,-1);
        for (int i=0;i<arr.length;i++){
            sum+=arr[i];
            int rem= sum%k;
            if(rem<0){
                rem+=k;
            }
            if(map.containsKey(rem)){
                int length= i - map.get(rem);
                if(maxLength < length){
                    maxLength=length;
                    initialPosition=map.get(rem);
                    finalPosition=i;
                    maxSum=sum;
                }
            }else{
                map.put(rem,i);
            }
        }

        System.out.println("The longest substring is between the position : ["+(initialPosition+1)+","+finalPosition+"]" );
    }
}
