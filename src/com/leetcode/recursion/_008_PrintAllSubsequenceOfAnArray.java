package com.leetcode.recursion;

import java.util.*;
import java.util.stream.Collectors;

public class _008_PrintAllSubsequenceOfAnArray {

    public static void main(String[] args) {
        int[] arr={2,5,2,1,2};
        System.out.println(printAllSubsequenceOfAnArray(arr));
    }

    private static List<List<Integer>> printAllSubsequenceOfAnArray(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int index = 0;
        printAllSubsequenceOfAnArray(arr, res, curr, index);
        Set<List<Integer>> currSet = new HashSet<>();
        for(List<Integer> list : res){
            Collections.sort(list);
            currSet.add(list);
        }
        return currSet.stream().collect(Collectors.toList());
    }

    private static void printAllSubsequenceOfAnArray(int[] arr, List<List<Integer>> res, List<Integer> curr, int index) {
        if (index == arr.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        // pick at the index
        curr.add(arr[index]);
        printAllSubsequenceOfAnArray(arr, res, curr, index + 1);

        curr.remove(curr.size() - 1);
        printAllSubsequenceOfAnArray(arr, res, curr, index + 1);
        // not pick at the index
    }
}
