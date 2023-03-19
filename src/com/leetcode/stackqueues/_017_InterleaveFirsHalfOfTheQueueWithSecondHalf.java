package com.leetcode.stackqueues;

import java.util.Queue;
import java.util.Stack;

/**
 * Given a queue of integers of even length, rearrange the elements by interleaving the first half of the queue with the second half of the queue.
 * <p>
 * Only a stack can be used as an auxiliary space.
 * <p>
 * Input :  11 12 13 14 15 16 17 18 19 20
 * Output : 11 16 12 17 13 18 14 19 15 20
 */
public class _017_InterleaveFirsHalfOfTheQueueWithSecondHalf {

    public static void main(String[] args) {
        Queue<Integer> queue = createQueue();
        interLeaveQueue(queue);
        for (int i = 0; i < queue.size(); i++) {
            System.out.print(queue.peek()+ " -> ");
            queue.add(queue.remove());
        }
        System.out.println("END");
    }

    private static Queue<Integer> interLeaveQueue(Queue<Integer> queue) {

        Stack<Integer> stack = new Stack<>();
        int halfSize = queue.size() / 2;

        for (int i = 0; i < halfSize; i++) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < halfSize; i++) {
            queue.add(queue.remove());
        }

        for (int i = 0; i < halfSize; i++) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
            queue.add(queue.remove());
        }
        return queue;

    }

    private static Queue<Integer> createQueue() {
        Queue<Integer> q = new java.util.LinkedList<>();
        q.add(11);
        q.add(12);
        q.add(13);
        q.add(14);
        q.add(15);
        q.add(16);
        q.add(17);
        q.add(18);
        q.add(19);
        q.add(20);
        return q;
    }


}
