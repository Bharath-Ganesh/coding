package com.leetcode.array;

import java.util.*;

/**
 * 56. Merge Intervals
 * Given an array of intervals where intervals{i} = {starti, endi},
 * merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Input: intervals = {{1,3},{2,6},{8,10},{15,18}}
 * Output: {{1,6},{8,10},{15,18}}
 * Explanation: Since intervals {1,3} and {2,6} overlaps, merge them into {1,6}.
 *
 * Input: intervals = {{1,4},{4,5}}
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *  * Input: intervals = {{1,4},{2,3}}
 *  * Output: [[1,4]]
 */
public class _077_MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        int[][] result= mergeLeetcode(intervals);
        for (int i=0;i<result.length;i++){
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public static int[][] mergeLeetcode(int[][] intervals) {

        List<int[]> list=new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int interval[] : intervals){
            if(interval[0]<=end){
                end=Math.max(end,interval[1]);
            }else {
                list.add(new int[]{start,end});
                start=interval[0];
                end=interval[1];
            }
        }
        list.add(new int[]{start,end});
        return list.toArray(new int[0][]);

    }



}
