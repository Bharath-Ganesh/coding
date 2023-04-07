package com.leetcode.dp;

/**
 * https://leetcode.com/problems/burst-balloons/
 */
public class BurstBalloons {

    public static void main(String[] args) {
        BurstBalloons obj = new BurstBalloons();
        int[] nums = {3, 1, 5, 8};
        System.out.println(obj.maxCoins(nums));
    }

    public int maxCoins(int[] nums) {

        int n = nums.length;
        int[] arr = new int[n + 2];
        for (int i = 0; i < n; i++) arr[i + 1] = nums[i];
        arr[0] = 1;
        arr[n + 1] = 1;

        return maxCoins(1, n, arr);
    }


    public int maxCoins(int i, int j, int[] arr) {

        if(i>j) return 0;

        int max=Integer.MIN_VALUE;
        for(int index=i;index<=j;index++){
            int cost=arr[i-1]*arr[index]*arr[j+1];
            int left=maxCoins(i,index-1,arr);
            int right=maxCoins(index+1,j,arr);
            max=Math.max(cost+left+right,max);
        }
        return max;
    }
}
