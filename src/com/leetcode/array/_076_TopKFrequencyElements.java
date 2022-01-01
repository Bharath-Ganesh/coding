package com.leetcode.array;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 */


class Solution {



}

public class _076_TopKFrequencyElements {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // build hash map : character and how often it appears
        Map<Integer, Integer> count = new HashMap();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // array of unique elements
        int n = count.size();
        int[] unique = new int[n];
        int i = 0;
        for (int num: count.keySet()) {
            unique[i] = num;
            i++;
        }

        // kth top frequent element is (n - k)th less frequent.
        // Do a partial sort: from less frequent to the most frequent, till
        // (n - k)th less frequent element takes its place (n - k) in a sorted array.
        // All element on the left are less frequent.
        // All the elements on the right are more frequent.
        quickselect(0, n - 1, n - k,unique,count);
        // Return top k frequent elements
        return Arrays.copyOfRange(unique, n - k, n);
    }

    public static void quickselect(int left, int right, int k_smallest,int[] unique,Map<Integer,Integer> count) {
        /*
        Sort a list within left..right till kth less frequent element
        takes its place.
        */

        // base case: the list contains only one element
        if (left == right) return;

        // select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);

        // find the pivot position in a sorted list
        pivot_index = partition(left, right, pivot_index,unique,count);

        // if the pivot is in its final sorted position
        if (k_smallest == pivot_index) {
            return;
        } else if (k_smallest < pivot_index) {
            // go left
            quickselect(left, pivot_index - 1, k_smallest,unique,count);
        } else {
            // go right
            quickselect(pivot_index + 1, right, k_smallest,unique,count);
        }
    }

    public static int partition(int left, int right, int pivot_index,int[] unique,Map<Integer,Integer> count) {
        int pivot_frequency = count.get(unique[pivot_index]);
        // 1. move pivot to end
        swap(unique,pivot_index, right);
        int store_index = left;

        // 2. move all less frequent elements to the left
        for (int i = left; i <= right; i++) {
            if (count.get(unique[i]) < pivot_frequency) {
                swap(unique,store_index, i);
                store_index++;
            }
        }

        // 3. move pivot to its final place
        swap(unique,store_index, right);

        return store_index;
    }

    public static void swap(int[] unique,int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }







}
