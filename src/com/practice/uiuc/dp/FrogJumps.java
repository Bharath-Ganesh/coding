package com.practice.uiuc.dp;

import java.util.Arrays;

public class FrogJumps {

    public static void main(String[] args) {
        FrogJumps obj = new FrogJumps();
        int[] stones = {0,1,3,5,6,8,12,17};
        System.out.println(obj.canCross(stones));
    }

    public boolean canCross(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n][n+1];
        Arrays.stream(dp).forEach(x -> Arrays.fill(x, -1));
        boolean b = canCross(stones, dp, 0, 0);
        return b;
    }

    public boolean canCross(int[] stones, int[][] dp, int index, int jump) {

        if(index == stones.length - 1) return true;

        if(dp[index][jump] != -1) {
            if (dp[index][jump] == 1){
                return true;
            }else{
                return false;
            }

        }

        for(int nextJump  = jump - 1; nextJump <= jump+1; nextJump++){
            if(nextJump > 0){
                int nextStone = stones[index] + nextJump;
                int nextStoneIndex  = findIndex(nextStone, index+1, stones);

                if(nextStoneIndex != -1){
                    dp[index][jump] = 1;
                    if(canCross(stones, dp, nextStoneIndex, nextJump)){
                        return true;
                    }
                }
            }
        }
        dp[index][jump] = 0;
        return false;
    }

    private int findIndex(int val, int left, int[] stones){
        int right = stones.length - 1;
        while(left <= right){
            int mid = (right - left)/2 + left;
            if(stones[mid] == val){
                return mid;
            }else if(stones[mid] < val){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
