package com.leetcode.array;

import java.util.Arrays;

/**
 * 338. Counting Bits
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 *
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 *
 *
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 */
public class _050_CountingBits {

    public static void main(String[] args) {
        int n=5;
        System.out.println(Arrays.toString(countBitsLeetcode(n)));
    }

    /**
     * Time : o(n)
     *
     */
    public static  int[] countBitsLeetcode(int n) {
        int[] result=new int[n+1];
        for(int num=1;num<=n;num++){
            result[num]=num%2+result[num/2];
        }
        return result;
    }


    /**
     * Time : o(n log k)
     *
     */
    public static int[] countBits(int n) {

        int[] result=new int[n+1];
        for(int i=0;i<=n;i++){
            result[i]=hammingWeight(i);
        }
        return result;

    }

    /**
     *   int count = 0;
     *   while (n != 0)
     *   {
     *   rightMostSetBit is the Bitwise and of n and n's 2's complement
     *   int rightMostSetBit= n & -n;
     *   n-=rightMostSetBit;
     *   count++;
     *   }
     * @param n
     * @return
     */
    private static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
