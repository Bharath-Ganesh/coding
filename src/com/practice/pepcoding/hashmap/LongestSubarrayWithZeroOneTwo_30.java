package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the longest subarray with equal 0's 1's and 2.
 *  int[] arr={1, 1 ,2 ,0 ,1 ,0 ,1 ,2 ,1 ,2 ,2 ,0, 1};
 */
public class LongestSubarrayWithZeroOneTwo_30 {

    public static void main(String[] args) {
        int[] arr={1, 1 ,2 ,0 ,1 ,0 ,1 ,2 ,1 ,2 ,2 ,0, 1};
        int length=longestSubarrayWithZeroOneTwo(arr);
        System.out.println("Max length : "+length);
    }

    private static int longestSubarrayWithZeroOneTwo(int[] arr) {
        int maxLength=0;

        int initialPosition=-1;
        int finalPosition=-1;

        //map
        Map<String,Integer> map= new HashMap<>();

        int countZero=0;
        int countOne=0;
        int countTwo=0;

        String key="";
        map.put(0+"#"+0,-1);
        for (int i=0;i<arr.length;i++){
            if(arr[i]==0){
                countZero++;
            }else if (arr[i]==1){
                countOne++;
            }else{
                countTwo++;
            }
            key= (countOne-countZero)+ "#" +  (countTwo-countOne);
           if(map.containsKey(key)){
               int length=i-map.get(key);
               if(maxLength<length){
                   maxLength=length;
                   initialPosition=map.get(key);
                   finalPosition=i;
               }
           }else{
               map.put(key,i);
           }
        }

        System.out.println("The longest subarray is between the position : ["+(initialPosition+1)+","+(finalPosition+1)+"]" );

        return maxLength;
    }
}
