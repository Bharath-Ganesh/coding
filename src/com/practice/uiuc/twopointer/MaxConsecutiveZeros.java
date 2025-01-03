package com.practice.uiuc.twopointer;

import java.util.Deque;
import java.util.LinkedList;

public class MaxConsecutiveZeros {

    public static void main(String[] args) {
        MaxConsecutiveZeros maxConsecutiveZeros = new MaxConsecutiveZeros();
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(maxConsecutiveZeros.longestOnes(nums,3));
    }

    public int longestOnes(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int n = nums.length;
        int left = 0;
        int right = 0;
        int k1 = 0;
        int maxLength = 0;
        while(right < n){

            if(nums[right] == 0){
                k1++;
                while(k1 > k){
                    if(nums[left] == 0) {
                        k1--;
                    }
                    left++;
                }
            }
            maxLength = Math.max(maxLength, (right - left) +1);
            right++;
        }
        return maxLength;
    }


//    public int longestOnes(int[] nums, int k) {
//
//        int left = -1;
//        int right = 0;
//        int n = nums.length;
//        int freqZero = 0;
//        int maxLength = 0;
//
//        // 0 0 0 1
//        while(right < n){
//
//            int num = nums[right];
//            if( num == 0){
//                freqZero ++;
//            }
//
//            while(freqZero > k){
//                left ++;
//                if(nums[left] == 0){
//                    freqZero--;
//                }
//            }
//            maxLength = Math.max((right - left), maxLength);
//            right++;
//        }
//        return maxLength;
//    }
}
