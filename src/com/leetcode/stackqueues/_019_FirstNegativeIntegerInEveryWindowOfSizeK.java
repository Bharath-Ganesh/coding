package com.leetcode.stackqueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.
 *
 * N = 5
 * A[] = {-8, 2, 3, -6, 10}
 * K = 2
 * Output :
 * -8 0 -6 -6
 * Explanation :
 * First negative integer for each window of size k
 * {-8, 2} = -8
 * {2, 3} = 0 (does not contain a negative integer)
 * {3, -6} = -6
 * {-6, 10} = -6
 */
public class _019_FirstNegativeIntegerInEveryWindowOfSizeK {

    public static void main(String[] args) {
        long arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int k=3;
        System.out.println(Arrays.toString(printFirstNegativeInteger(arr,arr.length,k)));
    }

    public static long[] printFirstNegativeInteger(long arr[], int n, int k)
    {
        long[] res=new long[n-k+1];
        Deque<Integer> dequeue=new ArrayDeque<>();

        for(int i=0;i<k-1;i++){
            if(arr[i]<0){
                dequeue.add(i);
            }
        }
        for(int i=k-1;i<n;i++){
            if(arr[i]<0){
                dequeue.add(i);
            }

            long val=0l;
            if(!dequeue.isEmpty()){
                val=arr[dequeue.peekFirst()];
            }
            res[(i+1)-(k)]=val;

            //deletion logic
            if(!dequeue.isEmpty() && i-dequeue.peekFirst()== k-1){
                dequeue.removeFirst();
            }
        }
        return res;
    }
}
