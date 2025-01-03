package com.practice.uiuc.bits;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {
        PowerSet obj = new PowerSet();
        int[] nums = {1, 2 , 3};
        obj.generatePowerSet(nums);
    }

    private void generatePowerSet(int[] nums) {
        int n = nums.length;
        int totalSubsets = 1 << n; // Total subsets = 2^n

        List<List<Integer>> powerSet = new ArrayList<>();
        // Iterate over all possible subset representations (0 to 2^n - 1)
        for (int subsetMask = 0; subsetMask < totalSubsets; subsetMask++) {
            List<Integer> currentSubset = new ArrayList<>();
            // Check each bit of the subset mask
            for (int bitIndex = 0; bitIndex < n; bitIndex++) {
                // If the bit at position bitIndex is set in subsetMask, include nums[bitIndex]
                if ((subsetMask & (1 << bitIndex)) != 0) {
                    currentSubset.add(nums[bitIndex]);
                }
            }
            powerSet.add(currentSubset); // Add the current subset to the power set
        }
        System.out.println(powerSet); // Print the power set
    }

}
