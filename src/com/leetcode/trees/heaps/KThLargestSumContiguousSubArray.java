package com.leetcode.trees.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class KThLargestSumContiguousSubArray {


    static int kthLargestSum(int arr[], int n, int k) {



        int[] prefixSum = new int[n + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        prefixSum[0] = 0;
        for (int i = 1; i <=arr.length; i++) {
            prefixSum[i] = arr[i-1] + prefixSum[i - 1];
        }

        for(int i=1;i<=arr.length;i++){
            for(int j=i;j<=arr.length;j++){
                int currSum=prefixSum[j]-prefixSum[i-1];
                if(pq.size() < k){
                    pq.add(currSum);
                }else{
                    if(pq.peek()<currSum){
                        pq.remove();
                        pq.add(currSum);
                    }
                }
            }
        }
        return pq.remove();
    }

    public static void main(String[] args) {
        int a[] = new int[]{10, -10, 20, -40};
        int n = a.length;
        int k = 6;
        System.out.println(kthLargestSum(a, n, k));
    }


}
