package com.leetcode.bits;

/**
 * GFG : https://practice.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1
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
 *
 * Input: N = 17
 * Output: 35
 * Explanation: From numbers 1 to 17(both inclusive),
 * the total number of set bits is 35.
 */
public class _008_CountTotalSetBits {

    public static void main(String[] args) {
        int n=3;
        System.out.println(countSetBits(n));
    }

    public static int countSetBits(int n){

        // Your code here
        if(n==0){
            return 0;
        }
        int powerof2=findMaxPowerOf2(n);
        int bitsTillMaxPower= powerof2 * (1 << (powerof2-1));
        int msbAfterMaxPower= n - (1 << powerof2) + 1;
        int res= n - (1 << powerof2);
        int ans= bitsTillMaxPower + msbAfterMaxPower + countSetBits(res);
        return ans;


    }

    public static int findMaxPowerOf2(int num){
        int power=0;
        while ( (1 << power) <= num ){
            power++;
        }
        return power-1;
    }

    //Function to return sum of count of set bits in the integers from 1 to n.
//    public static int countSetBits(int n){
//
//        if(n==0){
//            return 0;
//        }
//        int maxPower=powerOfTwo(n);
//        int countOfOnes=(1<<(maxPower-1))*maxPower;
//        int rmsb=(n-(1<<maxPower)+1);
//        int rest=(n-(1<<maxPower));
//        int answer=rmsb+countOfOnes+countSetBits(rest);
//        return answer;
//    }
//
//
//
//    private static int powerOfTwo(int number){
//        int count=0;
//        while((1 << count ) <= number){
//            count++;
//        }
//        return --count;
//    }
}
