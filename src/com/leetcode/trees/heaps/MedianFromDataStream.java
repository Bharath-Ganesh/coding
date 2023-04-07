package com.leetcode.trees.heaps;

import java.util.Collections;
import java.util.PriorityQueue;



class MedianFinder {
    PriorityQueue<Integer> max = null;
    PriorityQueue<Integer> min = null;
    double sum = 0;
    public MedianFinder() {
        this.max = new PriorityQueue<Integer>(Collections.reverseOrder());
        this.min = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        // max = max;
        this.max.add(num);
        this.min.add(this.max.poll());

        while(this.max.size() < this.min.size()){
            this.max.add(this.min.poll());
        }

    }

    public double findMedian() {
        int n = (this.max.size() + this.min.size());
        if(n%2 == 0){
            return (this.max.peek() + this.min.peek())/2.0;
        }
        else{
            return this.max.peek();
        }


    }
}

public class MedianFromDataStream {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;


    public MedianFromDataStream() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        int left = maxHeap.size();
        int right = minHeap.size();
        if (left == 0) { // left==0
            maxHeap.add(num);
        } else if (left == right) { //left==right
            if (minHeap.peek() > num) {
                maxHeap.add(num);
            } else {
                int temp = minHeap.remove();
                maxHeap.add(temp);
                minHeap.add(num);
            }
        } else if (right == 0) { //right==0
            if (maxHeap.peek() <= num) {
                minHeap.add(num);
            } else {
                int temp = maxHeap.remove();
                maxHeap.add(num);
                minHeap.add(temp);
            }
        }
//       else if(minHeap.peek() <= num) { // left > right
//            minHeap.add(num);
//        }
        else {
            if (maxHeap.peek() <= num) {
                minHeap.add(num);
            } else {
                int temp = maxHeap.remove();
                maxHeap.add(num);
                minHeap.add(temp);
            }
        }
    }

    public double findMedian() {
        int left = maxHeap.size();
        int right = minHeap.size();
        if ((left + right) % 2 == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFromDataStream obj=new MedianFromDataStream();
        obj.addNum(2);
        obj.addNum(3);
        System.out.println(obj.findMedian());
        obj.addNum(4);
        obj.addNum(8);
        obj.addNum(5);
        System.out.println(obj.findMedian());
        obj.addNum(9);
        obj.addNum(7);
        obj.addNum(10);
        System.out.println(obj.findMedian());
    }
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

}
