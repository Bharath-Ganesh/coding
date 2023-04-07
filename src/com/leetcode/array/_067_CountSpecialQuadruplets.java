package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a 0-indexed integer array nums, return the number of distinct quadruplets (a, b, c, d) such that:
 * <p>
 * nums[a] + nums[b] + nums[c] == nums[d], and
 * a < b < c < d
 * <p>
 * Input: nums = [1,2,3,6]
 * Output: 1
 * Explanation: The only quadruplet that satisfies the requirement is (0, 1, 2, 3) because 1 + 2 + 3 == 6.
 * <p>
 * Input: nums = [1,1,1,3,5]
 * Output: 4
 * Explanation: The 4 quadruplets that satisfy the requirement are:
 * - (0, 1, 2, 3): 1 + 1 + 1 == 3
 * - (0, 1, 3, 4): 1 + 1 + 3 == 5
 * - (0, 2, 3, 4): 1 + 1 + 3 == 5
 * - (1, 2, 3, 4): 1 + 1 + 3 == 5
 */
public class _067_CountSpecialQuadruplets {

    public static void main(String[] args) {
        int[] nums={1, 2, 3, 4, 9, 5, 10};
        System.out.println(countQuadrupletsLeetcode(nums));
    }


    public static int countQuadrupletsLeetcode(int[] nums) {
        int res = 0;
        int len = nums.length;

        Map<Integer, Integer> count = new HashMap<>();
        count.put(nums[len-1] - nums[len-2], 1);

        for (int b = len - 3; b >= 1; b--) {
            for (int a = b - 1; a >= 0; a--) {
                res += count.getOrDefault(nums[a] + nums[b], 0);
            }

            for (int x = len - 1; x > b; x--) {
                count.put(nums[x] - nums[b], count.getOrDefault(nums[x] - nums[b], 0) + 1);
            }
        }

        return res;
    }

    public static int countQuadruplets(int[] nums) {
        int count = 0;
        int n = nums.length;
        if (n == 4) {
           if(nums[0]+nums[1]+nums[2]==nums[3]){
               return 1;
           }
        }else{
            for(int i=0;i<n-3;i++){
                for(int j=i+1;j<n-2;j++){
                    for(int k=j+1;k<n-1;k++){
                        for(int l=k+1;l<n;l++){
                            if(nums[i]+nums[j]+nums[k]==nums[l]){
                                System.out.println(nums[i]);
                                System.out.println(nums[j]);
                                System.out.println(nums[k]);
                                System.out.println(nums[l]);
                                count++;
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}
