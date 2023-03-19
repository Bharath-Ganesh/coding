package com.leetcode.array;

import java.util.ArrayList;

/**
 * Factorials of large numbers
 * https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1#
 * Given an integer N, find its factorial.
 * <p>
 * Input: N = 10
 * Output: 3628800
 * Explanation :
 * 10! = 1*2*3*4*5*6*7*8*9*10 = 3628800
 */
public class _092_FactorialOfLargeNumber {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(factorial(n));
    }

    static ArrayList<Integer> factorial(int n){
        //code here
        ArrayList<Integer> result=new ArrayList<>();
        result.add(1);
        for(int num=2;num<=n;num++){
            int carry=0;
            for(int j=result.size()-1;j>=0;j--){
                int number=num*result.get(j)+carry;
                result.set(j,(number%10));
                carry=(number/10);
            }
            while(carry!=0){
                result.add(0,carry%10);
                carry=carry/10;
            }
        }
        return result;

    }


}
