package com.leetcode.array;

/**
 * 198. House Robber
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of
 * them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent
 * houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can
 * rob tonight without alerting the police.
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class _104_HouseRobber {

    public static void main(String[] args) {
        int[] nums = {1,3,1,3,100};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int maxTheft = 0;
        //initialize two variable for storing sum
        int ppm = nums[0];
        int pm = nums[1];

        int index = 0;
        for (index = 2; index < nums.length - 1; index += 2) {
            pm = Math.max(pm + nums[index + 1], ppm + Math.min(nums[index], nums[index + 1]));
            ppm = ppm + Math.max(nums[index], nums[index + 1]);

        }

        // last element left
        if (index == nums.length - 1) {
            maxTheft = Math.max(pm,ppm + nums[nums.length - 1]);
        } else {
            maxTheft = Math.max(ppm, pm);
        }

        return maxTheft;

    }
}
