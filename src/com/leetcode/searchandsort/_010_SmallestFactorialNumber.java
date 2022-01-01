package com.leetcode.searchandsort;

/**
 * Given a number n. The task is to find the smallest number whose factorial contains at least n trailing zeroes.
 * <p>
 * Input:
 * n = 1
 * Output: 5
 * Explanation : 5! = 120 which has at
 * least 1 trailing 0.
 */
public class _010_SmallestFactorialNumber {

    public static void main(String[] args) {
        int num = 93;
        System.out.println(findNum(num));
    }

    public static int findNum(int trailingZero)
    {
        // Complete this function
        int start=5;
        int end=5*trailingZero;
        int ans=-1;
        while(start<=end){
            int mid=(end-start)/2+start;
            if(isCountFive(mid,trailingZero)){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;

    }


    public static boolean isCountFive(int num,int trailingZero){
        int count=0;
        int fact=5;
        while(fact<=num){
            count+=num/fact;
            fact=fact*5;
        }
        return count>=trailingZero;
    }



    private static int findNumBruteForce(int n) {
        // Complete this function
        int fiveFact = 0;
        int count = 0;
        while (true) {
            boolean flag1 = true;
            fiveFact += 5;
            int quotient = fiveFact;
            while (quotient >= 5 && quotient % 5 == 0) {
                count++;
                quotient = quotient / 5;
                if (count >= n) {
                    return fiveFact;
                }
                flag1 = false;
            }
            if (flag1 == true) {
                break;
            }
        }
        return fiveFact;
    }
}
