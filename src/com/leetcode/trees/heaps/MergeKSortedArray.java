package com.leetcode.trees.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArray {

    public static void main(String[] args) {
        MergeKSortedArray obj = new MergeKSortedArray();
        int arr[][] = {{57, 81}, {63, 71}};
        int k = 2;
        System.out.println(mergeKArrays(arr, k));
    }

    static class Pair implements Comparable<Pair> {
        int[] arr;
        int index;

        public Pair(int[] arr, int index) {
            this.arr = arr;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o1) {
            return this.arr[index] - o1.arr[o1.index];
        }
    }


    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int k) {
        // Write your code here.
        ArrayList<Integer> res = new ArrayList<>();
        if (arr != null && arr.length == 0) {
            return res;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            int curr[] = arr[i];
            if (curr != null) {
                pq.add(new Pair(curr, 0));
            }
        }
        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            int[] curr = p.arr;
            int index = p.index;
            res.add(curr[index]);
            if (index < curr.length-1) {
                pq.add(new Pair(curr, index+1));
            }

        }
        return res;
    }

    static class ArrayBucket implements Comparable<ArrayBucket> {
        int[] arr;
        int index;

        public ArrayBucket(int arr[], int index) {
            this.arr = arr;
            this.index = index;
        }

        @Override
        public int compareTo(ArrayBucket o) {
            return this.arr[this.index] - o.arr[index];
        }
    }

    public static ArrayList<Integer> mergeKArraysComparator(int[][] arr, int K) {
        // Write your code here.
        PriorityQueue<ArrayBucket> q = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            q.add(new ArrayBucket(arr[i], 0));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ArrayBucket curr = q.poll();
            ans.add(curr.arr[curr.index]);
            if (curr.index < curr.arr.length - 1) {
                q.add(new ArrayBucket(curr.arr, curr.index + 1));
            }
        }
        return ans;
    }
}
