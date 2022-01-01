package com.leetcode.trees.heaps;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int arr[] = {1, 3, 1,2,0,5}, k = 3;
        System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindow(arr, k)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (!deque.isEmpty() && (i-k)==deque.peekFirst()) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < num) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (i >= (k - 1)) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int[] res = new int[(nums.length-k)+1];
//        Deque<Integer> deque = new LinkedList<>();
//        for (int index = 0; index < nums.length; index++) {
//            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[index]) {
//                deque.pollLast();
//            }
//            deque.add(index);
//
//            if(!deque.isEmpty() && (index-deque.peekFirst()) >= k){
//                deque.pollFirst();
//            }
//            if(index >= (k-1)){
//                res[(index-k)+1]=nums[deque.peekFirst()];
//            }
//        }
//        return res;
//    }
}
