package com.practice.uiuc.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindMinDiff {

    public static void main(String[] args) {
        FindMinDiff obj = new FindMinDiff();
        // 3, 4, 1, 9, 56, 7, 9, 12
        // 1, 3, 4, 4, 7, 9, 12, 56
        System.out.println(obj.findMinDiff(Arrays.asList(13 ,7, 8, 8, 10, 4, 10), 7));

    }

    public int findMinDiff(List<Integer> arr, int k) {
        // your code here

        Collections.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i=k-1; i<arr.size(); i++){
            minDiff = Math.min(minDiff, arr.get(i) - arr.get(i+1-k));
        }
        return minDiff;
    }
}
