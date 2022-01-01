package com.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */
public class ContainsDuplicate_20 {

    public static void main(String[] args) {
        int[] nums= {1,4,5,3};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEachOrdered(x->set.add(x));
        if(set.size()!=nums.length){
            return true;
        }
        return false;
    }
}
