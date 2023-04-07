package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an expression containing zero and one, we have to find the longest subarray of 1 provided
 * you can flip atmost k zero's
 * <p>
 * String exp="1101001101011";
 * OUTPUT
 * 7 (1101011)
 */
public class longestConsecutiveSubarrayOfOne_14 {

    public static void main(String[] args) {
        String exp = "1101001101011";
        int maxFlip=2;
        int length = longestConsecutiveSubarrayOfOne(exp,maxFlip);
        System.out.println(length);
    }

    private static int longestConsecutiveSubarrayOfOne(String exp,Integer maxFlip) {

        int maxLength = 0;

        //sliding window
        int i=-1;
        int j=-1;

        int countZero=0;
        
        while (i<exp.length()-1){

            i++;
            Character ch =exp.charAt(i);
            if(ch== '0'){
                countZero++;
            }

            while(countZero>maxFlip){
                j++;
                Character charTobeRemoved =exp.charAt(j);
                if(charTobeRemoved=='0'){
                    countZero--;
                }
            }

            int length= i-j;
            if(length > maxLength){
                maxLength=length;
            }

        }
        return maxLength;
    }
}
