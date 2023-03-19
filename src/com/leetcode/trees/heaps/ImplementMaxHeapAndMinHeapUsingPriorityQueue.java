package com.leetcode.trees.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ImplementMaxHeapAndMinHeapUsingPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10, (a, b) -> b - a);

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        int[] elements = {1, 10, 5, 3, 4, 7, 6, 9, 8};

        minHeap.addAll(Arrays.stream(elements).boxed().collect(Collectors.toList()));
        maxHeap.addAll(Arrays.stream(elements).boxed().collect(Collectors.toList()));

        System.out.println("Min heap:");

        while (minHeap.size() != 0) {
            System.out.print( minHeap.poll() + " ");
        }

        System.out.println("\nMax heap:");
        while (maxHeap.size() != 0) {
            System.out.print(maxHeap.poll()+ " ");
        }
    }
}
