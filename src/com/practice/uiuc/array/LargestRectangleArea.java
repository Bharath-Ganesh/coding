package com.practice.uiuc.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class LargestRectangleArea {

    public static void main(String[] args) {
        LargestRectangleArea obj = new LargestRectangleArea();
        int[] heights = {2,1,5,6,2,3};
        System.out.println(obj.largestRectangleAreaOptimal(heights));
    }

    public int largestRectangleAreaOptimal(int[] heights) {

        int n = heights.length;

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int left = 0; left<n; left++){

            while(!stack.isEmpty() && heights[stack.peek()] >= heights[left]){
                int element = stack.pop();
                int nseToLeft = -1;
                if(!stack.isEmpty()){
                    nseToLeft = stack.peek();
                }
                maxArea = Math.max(maxArea, (left - nseToLeft - 1) * heights[element]);
            }
            stack.push(left);
        }


        while(!stack.isEmpty()){
            int element = stack.pop();
            int nseToLeft = -1;
            if(!stack.isEmpty()){
                nseToLeft = stack.peek();
            }
            maxArea = Math.max(maxArea, (n - nseToLeft - 1) * heights[element]);
        }
        return maxArea;
    }


    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int[] rightMin = new int[n];
        int[] leftMin = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int right = n-1; right>=0; right--){

            while(!stack.isEmpty() && heights[stack.peek()] >= heights[right]){
                stack.pop();
            }

            if(stack.isEmpty()){
                rightMin[right] = n;
            }else {
                rightMin[right] = stack.peek();
            }

            stack.push(right);
        }

        stack = new Stack<>();
        for(int left = 0; left<n; left++){

            while(!stack.isEmpty() && heights[stack.peek()] >= heights[left]){
                stack.pop();
            }

            if(stack.isEmpty()){
                leftMin[left] = -1;
            }else {
                leftMin[left] = stack.peek();
            }

            stack.push(left);
        }

        int result = 0;
        for(int i=0; i<n; i++){
            int window =  rightMin[i] - leftMin[i] - 1;
            int area = window * heights[i];
            result = Math.max(result, area);
        }
        return result;
    }
}


class Solution {

    class Pair implements Comparable<Pair> {

        int freq;
        int element;

        public Pair(int element, int freq){
            this.element = element;
            this.freq = freq;
        }

        public int compareTo(Pair pair){
            return this.freq - pair.freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        int[] result = new int[k];

        PriorityQueue<Pair> minHeap = new PriorityQueue<>();

        for(int i=0; i<nums.length; i++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        int count = 0;
        Pair[] pairs = new Pair[freqMap.size()];

        for(Map.Entry<Integer, Integer> mapEntrySet : freqMap.entrySet()){
            pairs[count++] = new Pair(mapEntrySet.getKey(), mapEntrySet.getValue());
        }

        int i;
        for(i=0; i<k; i++){
            minHeap.add(pairs[i]);
        }

        while(i < pairs.length) {

            if(minHeap.peek().freq < pairs[i].freq){
                minHeap.remove();
                minHeap.add(pairs[i]);
            }
        }

        count = 0;
        while (!minHeap.isEmpty()){
            result[count++] = minHeap.remove().element;
        }
        return result;

    }
}