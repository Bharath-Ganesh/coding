package com.leetcode.trees.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeTwoBinaryMaxHeaps {

    public static void main(String[] args) {
        int a[] = {10, 5, 6, 2};
        int b[] = {12, 7, 9};
        MergeTwoBinaryMaxHeaps obj = new MergeTwoBinaryMaxHeaps();
        int[] res = obj.mergeHeaps(a, b, a.length, b.length);
        System.out.println(Arrays.toString(res));
    }

    public int[] mergeHeaps(int[] arr1, int[] arr2, int n, int m) {
        // your code here
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(b-a));
        Arrays.stream(arr1).boxed().forEach(pq::add);
        Arrays.stream(arr2).boxed().forEach(pq::add);
        int[] res=new int[n+m];
        int index=0;
        while (!pq.isEmpty()){
            res[index++]=pq.remove();
        }
        return res;
    }

}
