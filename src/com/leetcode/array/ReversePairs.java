package com.leetcode.array;

/**
 * https://leetcode.com/problems/reverse-pairs/
 */
public class ReversePairs {

    public static void main(String[] args) {
        ReversePairs rev = new ReversePairs();
        int[] nums ={6,8,9,2,3};
        System.out.println(rev.reversePairs(nums));
    }

    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return reversePairs(temp, nums, 0, nums.length - 1);
    }

    public int reversePairs(int[] temp, int[] nums, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            count += reversePairs(temp, nums, low, mid);
            count += reversePairs(temp, nums, mid + 1, high);
            count += mergePairs(temp, nums, low, mid + 1, high);
        }
        return count;
    }

    public int mergePairs(int[] temp, int[] nums, int low, int mid, int high) {

        int count = 0;
        int j = mid;
        for (int i = low; i <= mid-1; i++) {
            while (j <= high && nums[i] > 2 * (long) nums[j]) {
                j++;
            }
            count += (j - (mid));
        }

        int i = low;
        j = mid;
        int index = low;

        while (i <= mid - 1 && j <= high) {
            if (nums[i] < nums[j]) {
                temp[index++] = nums[i++];
            } else {
                temp[index++] = nums[j++];
            }
        }

        while (i <= mid - 1) {
            temp[index++] = nums[i++];
        }

        while (j <= high) {
            temp[index++] = nums[j++];
        }

        for (i = low; i <= high; i++) {
            nums[i] = temp[i];
        }
        return count;
    }
}

