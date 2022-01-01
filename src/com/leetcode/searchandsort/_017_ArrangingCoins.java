package com.leetcode.searchandsort;

/*
You have n coins and you want to build a staircase with these coins.
The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build.

Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.
 */
public class _017_ArrangingCoins {

    public static void main(String[] args) {
        int n=1804289383;
        System.out.println(arrangeCoins(n));
    }
    public static int arrangeCoins(int n) {

        long low=1;
        long high=n;
        long ans=1l;
        while(low<=high){
            long row=(high-low)/2+low;
            if( (row*(row+1)/2) <=n){
                ans=row;
                low=row+1;
            }else{
                high=row-1;
            }
        }
        return (int) ans;
    }
}
