package com.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 56. Merge Intervals
 * Given an array of intervals where intervals{i} = {starti, endi},
 * merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * <p>
 * Input: intervals = {{1,3},{2,6},{8,10},{15,18}}
 * Output: {{1,6},{8,10},{15,18}}
 * Explanation: Since intervals {1,3} and {2,6} overlaps, merge them into {1,6}.
 * <p>
 * Input: intervals = {{1,4},{4,5}}
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * <p>
 * * Input: intervals = {{1,4},{2,3}}
 * * Output: [[1,4]]
 */
public class _077_MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{2, 6}, {1, 3}, {15, 18}, {8, 10}};
        int[][] result = mergeLeetcode(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
        System.out.println(Integer.MIN_VALUE);
//        int[] nums={1,0,-1,0,-2,2};
//        fourSum(nums,0);
    }

    public static int[][] mergeLeetcode(int[][] intervals) {

        List<int[]> list = new ArrayList<>();


        /**
         * Anonymous inner class
         */
        Comparator<int[]> comparator = new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //return o1[0] > o2[0] ? 1 : -1;
                return o1[0] > o2[0] ? 1 : -1;
            }
        };

        /**
         * Using lambda expression
         */
        Comparator<int[]> comparator1 = (o1, o2) -> o1[0] > o2[0] ? 1 : -1;

        /**
         * Using Comparator.comparingInt
         * This can only be used while using the natural sorting , ascending.
         */
        Comparator<int[]> comparator2 = Comparator.comparingInt(o -> o[0]);


        Arrays.sort(intervals, comparator2);

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int interval[] : intervals) {
            if (interval[0] <= end) {
                end = Math.max(end, interval[1]);
            } else {
                list.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }

//        List<Integer> sampleList = Arrays.asList(2, 2, 4, 1);
//        Integer[] temp = new Integer[sampleList.size()];
//        Object[] objects = sampleList.toArray();
//        Integer[] integers = sampleList.toArray(temp);
//        Integer[] integerss = sampleList.toArray(new Integer[0]);
//
//        List<int[]> res2=new ArrayList<>();
//        int[][] ints = new int[2][];
//        int[] s={1,2,2,2,2,2,4};
//        int[] s1={1,2,2,2,2,2,4,4,4,4,4};
//        ints[0]=s;
//        ints[1]=s1;
//        ints[1]=new int[2];

        //int[][] obj=res2.toArray();

        list.add(new int[]{start, end});
        return list.toArray(new int[list.size()][2]);


    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n - 3; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                for (int j = i + 1; j < n - 2; j++) {
                    if (j == i + 1 || (nums[j] != nums[j - 1])) {
                        int sum = target - (nums[i] + nums[j]);
                        int low = j + 1;
                        int high = n - 1;
                        while (low < high) {
                            if (nums[low] + nums[high] == sum) {
                                List<Integer> currList = new ArrayList<>();
                                currList.add(nums[i]);
                                currList.add(nums[j]);
                                currList.add(nums[low]);
                                currList.add(nums[high]);

                                while (low != n - 1 && nums[low] == nums[low + 1]) low++;
                                while (high != 0 && nums[high] == nums[high - 1]) high--;
                                low++;
                                high--;
                            } else if (nums[low] + nums[high] > sum) {
                                high--;
                            } else {
                                low++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }



}
