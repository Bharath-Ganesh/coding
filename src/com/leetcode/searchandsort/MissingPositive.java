package com.leetcode.searchandsort;

public class MissingPositive {

    public static void main(String[] args) {
        MissingPositive obj = new MissingPositive();
        int[] nums = {2, 1};
        System.out.println(obj.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return nums[0] == 1 ? 2 : 1;
        }
        int index = 0;
        while (index < n) {
            if (nums[index] > n || nums[index] <= 0) {
                index++;
                continue;
            }
            int correctIndex = nums[index] - 1;
            if (nums[index] != nums[correctIndex]) {
                swap(index, correctIndex, nums);
            } else {
                index++;
            }
        }

        for (index = 0; index < n; index++) {
            if (nums[index] != index + 1) {
                return index + 1;
            }
        }
        return index + 1;
    }

    private void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
