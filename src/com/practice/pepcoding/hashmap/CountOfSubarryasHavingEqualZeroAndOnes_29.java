package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the count of subarrays having equal zero and ones
 * Integer arr[]= {0,0,1,0,1,0,1,1,0,0,1,1,1};
 * output
 */
public class CountOfSubarryasHavingEqualZeroAndOnes_29 {
    public static void main(String[] args) {
        Integer arr[]= {0,0,1,0,1,0,1,1,0,0,1,1,1};
        int count=countOfSubarryasHavingEqualZeroAndOnes(arr);
        System.out.println(count);
    }

    private static int countOfSubarryasHavingEqualZeroAndOnes(Integer[] arr) {
        int count=0;

        //for storing freq and sum
        Map<Integer,Integer> freqMap = new HashMap<>();
        int sum=0;
        //first index
        freqMap.put(sum,1);

        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                sum+=-1;
            }else{
                sum+=arr[i];
            }
            if(freqMap.containsKey(sum)){
                count+=freqMap.get(sum);
                freqMap.put(sum,freqMap.get(sum)+1);
            }else{
                freqMap.put(sum,1);
            }
        }

        return count;
    }
}
