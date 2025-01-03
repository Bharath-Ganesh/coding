package com.practice.uiuc.greedy;

public class JumpGame2 {
    public static void main(String[] args) {
        JumpGame2 obj = new JumpGame2();
        int[] nums = {1, 1, 2, 4, 3, 1, 1, 1, 1};
        System.out.println(obj.jump(nums));
    }

    public int jump(int[] nums) {

        int n = nums.length;
        int index  = 0;
        int maxJumpSoFar = 0;
        int minJumps = 0;

        while(index < n){

            if(index  == maxJumpSoFar){
                minJumps+=1;
            }
            maxJumpSoFar = Math.max(maxJumpSoFar, index + nums[index]);
            if(maxJumpSoFar >= n-1) return minJumps+1;
            index++;
        }
        return minJumps;

    }
}
