package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1497. Check If Array Pairs Are Divisible by k
 * Given an array of integers arr of even length n and an integer k.
 *
 * We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
 *
 * Return true If you can find a way to do that or false otherwise.
 *
 * Input: arr = [1,2,3,4,5,10,6,7,8,9], k = 5
 * Output: true
 * Explanation: Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).
 *
 * Input: arr = [1,2,3,4,5,6], k = 7
 * Output: true
 * Explanation: Pairs are (1,6),(2,5) and(3,4).
 *
 *  Input: arr = [-1,1,-2,2,-3,3,-4,4], k = 3
 *  Output: true
 *  Explanation: Pairs are (1,6),(2,5) and(3,4).
 *
 *
 *
 */
public class _063_CheckIfArrayPairsAreDivByK {

    public static void main(String[] args) {
        int[] arr = {75,5,-5,75,-2,-3,88,10,10,87};
        int k = 85;
        System.out.println(canArrangeLeetcode(arr,k));
    }

    /**
     * Optimum solution
     */
    public static boolean canArrangeLeetcode(int[] arr, int k) {
        int[] freq=new int[k];
        for(int num : arr){
            num%=k;
            if(num<0){
                num+=k;
            }
            freq[num]++;
        }

        if(freq[0]%2!=0){
            return false;
        }

        for(int i=1;i<=k/2;i++){
            if(freq[i]!=freq[k-i]){
                return false;
            }
        }
        return true;
    }

    public static boolean canArrange(int[] arr, int k) {
        int count=0;
        Map<Integer,Integer> remFreqMap=new HashMap();
        for(int num : arr){
            int rem=num%k>=0?num%k:k+(num%k);
            remFreqMap.put(rem,remFreqMap.getOrDefault(rem,0)+1);
        }


        for(int rem : remFreqMap.keySet()){
            if(rem>k/2){
                continue;
            }
            int freq=remFreqMap.get(rem);
            if(rem==0 || 2*rem==k){
                count+=(freq/2);
            }else{
                int corrFreq=remFreqMap.getOrDefault(k-rem,0);
                count+=Math.min(freq,corrFreq);
            }
        }
        System.out.println(count);
        return (count==arr.length/2)?true:false;
    }
}
