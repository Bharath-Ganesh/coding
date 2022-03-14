package com.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * <p>
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 */
public class _090_LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] arr = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(arr));

    }


    public static int longestConsecutive(int[] nums) {

        if(nums.length==0){
            return 0;
        }
        Set<Integer> set=new HashSet<>();
        for(int num:  nums){
            set.add(num);
        }

        int maxLength=0;
        for(int num : nums){
            if(!set.contains(num-1)){
                int potentialMin=num;
                int counter=1;
                while(set.contains(potentialMin+1)){
                    potentialMin++;
                    counter++;
                }
                maxLength=Math.max(maxLength,counter);
            }
        }
        return maxLength;

    }

    /**
     * O(Nlogn)
     * @param nums
     * @return
     */
    public static int longestConsecutiveBruteForce(int[] nums) {
        int maxLength = 1;
        Arrays.sort(nums);
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                counter++;
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                counter = 1;
            }
            maxLength=Math.max(counter,maxLength);
        }
        return maxLength;
    }

}

