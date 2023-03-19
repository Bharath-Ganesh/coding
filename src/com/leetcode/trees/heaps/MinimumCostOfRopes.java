package com.leetcode.trees.heaps;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {
    public static void main(String[] args) {
        long arr[] = {4, 3, 2, 6};
        long l = new MinimumCostOfRopes().minCost(arr, arr.length);
        System.out.println(l);

    }

    public long minCost(long arr[], int n)
    {
        // your code here
        long sum=0;
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(long element : arr){
            pq.add(element);
        }
        while(pq.size()>1){
            long first=pq.remove();
            long second=pq.remove();
            sum+=first+second;
            pq.add(first+second);
        }
        return sum;
    }
}
