package com.leetcode.array;

import java.util.Arrays;

/**
 * 1313. Decompress Run-Length Encoded List
 *
 * We are given a list nums of integers representing a list compressed with run-length encoding.
 *
 * Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]] (with i >= 0).  For each such pair, there are freq elements with value val concatenated in a sublist. Concatenate all the sublists from left to right to generate the decompressed list.
 *
 * Return the decompressed list.
 *
 * Input: nums = [1,2,3,4]
 * Output: [2,4,4,4]
 * Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
 * The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
 * At the end the concatenation [2] + [4,4,4] is [2,4,4,4].
 */
public class DecompressRunLengthEncodedList_33 {

    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        System.out.println(Arrays.toString(decompressRLElist(nums)));
    }

    public static int[] decompressRLElist(int[] nums) {

        int size=0;
        for(int i=0;i<nums.length;i+=2){
            size+=nums[i];
        }
        int[] res=new int[size];
        int counter=0;
        for(int i=0;i<nums.length;i+=2){
            int freq=nums[i];
            int val=nums[i+1];
            for(int j=0;j<freq;j++){
                res[counter++]=val;
            }
        }

        return res;
    }
}
