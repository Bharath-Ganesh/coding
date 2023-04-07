package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the count of all subarrays whose sum is divisible by k
 *
 * Integer arr[]= {2,3,5,4,5,3,4}
 * int k=7
 * Output
 * 4
 * [{2,3,5,4},{5,4,5},{3,4},{5,4,5,3,4}]
 */
public class CountOfSubarraysWithSumDivByK_27 {

    public static void main(String[] args) {
        Integer arr[]= {2,3,5,4,5,3,4};
        int k=7;
        int count=countOfSubarraysWithSumDivByK(arr,k);
        System.out.println("Count of subarrays having sum div by k : "+ count);
    }

    private static int countOfSubarraysWithSumDivByK(Integer[] arr, int k) {
        int maxCount=0;

        //freq map
        Map<Integer,Integer> freqMap = new HashMap<>();
        int sum=0;
        freqMap.put(sum,1);

        for (int i=0;i<arr.length;i++){
            sum+=arr[i];
            int rem = sum%k;

            // when remainder is negative
            if(rem<0){
                rem+=k;
            }

            if(freqMap.containsKey(rem)){
                maxCount+=freqMap.get(rem);
                freqMap.put(rem,freqMap.get(rem)+1);
            }else{
                //put the rem into map such that when we get the occurrence of two sums with same remainders,
                //like s1 and s2 which leaves same remainder,
                // s2-s1 = k(n) -k(m)=k(n-m)
                freqMap.put(rem,1);
            }
        }
        return maxCount;
    }
}
