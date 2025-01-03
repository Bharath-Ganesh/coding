package com.practice.uiuc;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        int [] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        obj.maxSlidingWindow(nums, k);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new LinkedList<>();

        int index = 0;
        int counter = 0;
        int n = nums.length;
        int[] result = new int[n-k+1];


        for(; index < k - 1; index++){

            if(deque.isEmpty()){
                deque.addFirst(index);
            }else{
                if(nums[index] > nums[deque.peekFirst()]){
                    deque.removeFirst();
                    deque.addFirst(index);
                }else{
                    deque.addLast(index);
                }
            }
        }
        // 0 1  2  3 4 5 6 7
        // 1,3,-1,-3,5,3,6,7

        // 1 2 4
        for(; index < n; index++){

            if(deque.isEmpty()){
                deque.addFirst(index);
            }else{
                if(nums[index] > nums[deque.peekFirst()]){
                    deque.removeFirst();
                    deque.addFirst(index);
                }else{
                    deque.addLast(index);
                }
            }

            result[counter++] = nums[deque.peekFirst()];
        }
        return result;
    }


}
