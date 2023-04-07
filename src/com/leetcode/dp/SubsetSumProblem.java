package com.leetcode.dp;

import com.leetcode.linkedlist.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * https://www.codingninjas.com/codestudio/problems/subset-sum-equal-to-k_1550954
 */
public class SubsetSumProblem {

    public static void main(String[] args) {
        SubsetSumProblem subsetSumProblem = new SubsetSumProblem();
        int[] nums = {3, 34, 4, 12, 5, 2};
        int target = 30;
        boolean b = subsetSumProblem.isSubsetSum(nums.length,nums, target);
        System.out.println(b);
    }

    static Boolean isSubsetSum(int n, int arr[], int target){
        // code here

        int sum= IntStream.of(arr).sum();
        System.out.println(sum);
        Comparator<ListNode> c=new Comparator<ListNode>(){

            public int compare(ListNode a,ListNode b){
                return a.val-b.val;
            }
        };

        boolean[][] dp=new boolean[n][target+1];

        //6 ; 3 34 4 12 5 2 ; 30
        dp[0][0]=true;
        if(arr[0]<=target) dp[0][arr[0]]=true;

        for(int row=1;row<n;row++){
            for(int col=0;col<=target;col++){
                if(col==0){
                    dp[row][col]=true;
                }else{
                    boolean notTake=dp[row-1][col];
                    boolean take=false;
                    if(col>=arr[row]){
                        take=dp[row-1][col-arr[row]];
                    }
                    dp[row][col]=notTake || take;
                }
            }
        }


        return dp[n-1][target];
    }
    public static boolean subsetSumToKTabulation(int n, int k, int arr[]) {
        // Write your code here.
        boolean[][] dp = new boolean[n][k + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][arr[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= k; target++) {
                boolean notTake = dp[i - 1][target];
                boolean take = false;
                if (arr[i] <= target) {
                    take = dp[i - 1][target - arr[i]];
                }
                dp[i][target] = take || notTake;
            }
        }
        Arrays.stream(dp).forEach(nums -> System.out.println(Arrays.toString(nums)));
        return dp[n - 1][k];
    }

    public static boolean subsetSumToK(int index, int target, int arr[]) {
        // Write your code here.
        int[][] dp = new int[index][target + 1];
        Arrays.stream(dp).forEach(nums -> Arrays.fill(nums, -1));
        boolean b = subsetSumToK(arr.length - 1, target, arr, dp);
        return b;
    }

    public static boolean subsetSumToK(int index, int target, int arr[], int[][] dp) {
        // Write your code here.
        if (target == 0) {
            return true;
        }
        if (index == 0) {
            return arr[0] == target;
        }
        if (dp[index][target] != -1) {
            return dp[index][target] == 1 ? true : false;
        }
        boolean notTake = subsetSumToK(index - 1, target, arr, dp);
        boolean take = false;
        if (arr[index] <= target) {
            take = subsetSumToK(index - 1, target - arr[index], arr, dp);
        }
        int val = notTake || take == true ? 1 : 0;
        dp[index][target] = val;
        return notTake || take;
    }


}
