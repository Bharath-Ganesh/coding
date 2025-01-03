package com.practice.uiuc;

public class CountNumberOfNiceSubArrays {

    public static void main(String[] args) {
        CountNumberOfNiceSubArrays obj = new CountNumberOfNiceSubArrays();
        int[] nums = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
        int k = 2;
        System.out.println(obj.numberOfSubarrays(nums, k));
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int goal) {
        if (goal < 0)
            return 0;
        int res = 0;

        int left = 0, right = 0;
        int n = nums.length;
        int countOdd = 0;

        while (right < n) {
            if (nums[right] % 2 == 1)
                countOdd++;

            while (countOdd > goal) {
                if (nums[left++] % 2 == 1)
                    countOdd--;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }
}
