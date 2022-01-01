package com.leetcode.array;

/**
 * 35. Search Insert Position
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity
 * <p>
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 */
public class SearchInsertPosition_21 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6,8,10};
        int target = 7;
        System.out.println(searchInsert2(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {

        int startIndex = 0;
        int endIndex = nums.length - 1;
        int midIndex = 0;

        if (nums[0] >= target) {
            return 0;
        }
        while (startIndex <= endIndex) {
            midIndex = (endIndex - startIndex) / 2 + startIndex;
            if (nums[midIndex] == target) {
                return midIndex;
            } else if (nums[midIndex] > target) {
                endIndex = midIndex - 1;
            } else {
                startIndex = midIndex + 1;
            }
        }

        return startIndex;
    }


    public static int searchInsert2(int[] nums, int target) {


        if (nums[0] > target) {
            return 0;
        }

        if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (nums[start] > target) {
            return start;
        }
        return start + 1;

    }
}
