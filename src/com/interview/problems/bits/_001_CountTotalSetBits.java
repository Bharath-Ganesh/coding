package com.interview.problems.bits;

/**
 * You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).
 *
 * Input: N = 4
 * Output: 5
 * Explanation:
 * For numbers from 1 to 4.
 * For 1: 0 0 1 = 1 set bits
 * For 2: 0 1 0 = 1 set bits
 * For 3: 0 1 1 = 2 set bits
 * For 4: 1 0 0 = 1 set bits
 * Therefore, the total set bits is 5.
 */
public class _001_CountTotalSetBits {

    public static void main(String[] args) {
        int n=4;
        System.out.println(countSetBits(n));
    }

    /**
     *
     * Time  : O(n * log Max)
     * Space : O(1)
     */
    public static int countSetBits(int n){
        // Your code here
        int count=0;
        for(int i=1;i<=n;i++){
            count+=totalBits(i);
        }
        return count;

    }

    private static int totalBits(int number){
        int count=0;
        while(number!=0){
            count++;
            number= number& number-1;
        }
        return count;
    }


}
