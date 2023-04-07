package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the smallest subarray with maximum frequency
 *
 * Integer num[]= {1,3,2,4,8,2,1,2,4,5,2,1,5,5,5,52,3,1}
 */
public class SmallestSubarrayWithHighestFrequency_35 {
    public static void main(String[] args) {
        Integer num[]= {1,3,2,4,8,2,1,2,4,5,2,1,5,5,5,52,3,1};
        smallestSubarrayWithHighestFrequency(num);

    }

    private static void smallestSubarrayWithHighestFrequency(Integer[] num) {
        int highestFrequency=0;
        int startIndex=0;
        int lastIndex=0;
        int length=0;
        Map<Integer,Integer> freqMap=new HashMap<>();
        Map<Integer,Integer> startIndexMap=new HashMap<>();
        for (int i=0;i<num.length;i++){
            int number=num[i];
            if(freqMap.containsKey(number)){
                freqMap.put(number,freqMap.get(number)+1);
            }else{
                freqMap.put(number,1);
                startIndexMap.put(number,i);
            }

            if(freqMap.get(number)>highestFrequency){
                highestFrequency=freqMap.get(number);
                startIndex=startIndexMap.get(number);
                lastIndex=i;
                length=lastIndex-startIndex+1;
            }else if(freqMap.get(number)==highestFrequency){
                int challengingLength=i-(startIndexMap.get(number))+1;
                if(challengingLength<length){
                    highestFrequency=freqMap.get(number);
                    startIndex=startIndexMap.get(number);
                    lastIndex=i;
                    length=challengingLength;
                }
            }
        }

        System.out.println("Highest freq " + highestFrequency);
        System.out.println("Start Index " + startIndex);
        System.out.println("Last Index "+ lastIndex);
        System.out.println("Element "+ num[startIndex]);
        System.out.println("Length "+length);


    }
}
