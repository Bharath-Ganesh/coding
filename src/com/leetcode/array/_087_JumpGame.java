package com.leetcode.array;

/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum
 * jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class _087_JumpGame {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {

        if (nums[0] == 0) {
            if (nums.length == 1) {
                return true;
            }
            return false;
        }

        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxDistance < i) {
                return false;
            }
            maxDistance = Math.max(maxDistance, i + nums[i]);
        }
        return true;
    }
}
