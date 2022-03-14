package com.leetcode.bits;

/**
 * 231. Power of Two
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 *
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 *
 *Input: n = 1
 * Output: true
 * Explanation: 20 = 1
 *
 * Input: n = 16
 * Output: true
 * Explanation: 24 = 16
 */
public class _005_PowerOfTwo {
    public static void main(String[] args) {
        int n=Integer.MIN_VALUE;
        System.out.println(n);
        System.out.println(n-1);
        System.out.println(isPowerOfTwo(n));
    }

    /**
     * Take care of negative numbers
     * */
    public static boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }else{
            return ((n&n-1)==0?true:false);
        }
    }
}
