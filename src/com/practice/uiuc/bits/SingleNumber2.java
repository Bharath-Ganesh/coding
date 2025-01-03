package com.practice.uiuc.bits;

public class SingleNumber2 {

    public static void main(String[] args) {
        SingleNumber2 obj = new SingleNumber2();
        int[] nums = {2,2,3,2};
        obj.singleNumber(nums);
    }

    public int singleNumber(int[] nums) {
        // `ones` keeps track of the numbers appearing once.
        // `twos` keeps track of the numbers appearing twice.
        int ones = 0, twos = 0;

        for (int num : nums) {
            // Update `ones` with the XOR of current number
            // AND ensure it does not include numbers already in `twos`.
            System.out.println("(ones ^ num) & (~twos) \t" + (ones ^ num) + " & " + " (~" + twos + ")");
            ones = (ones ^ num) & (~twos);

            // Update `twos` with the XOR of current number
            // AND ensure it does not include numbers already in `ones`.
            System.out.println("(twos ^ num) & (~ones) \t" + (twos ^ num) + " & " + " (~" + ones + ")");
            twos = (twos ^ num) & (~ones);

        }

        // At the end, `ones` will hold the number that appears exactly once,
        // because all numbers that appear three times are reset to zero in both `ones` and `twos`.
        return ones;
    }

}
