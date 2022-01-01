package com.leetcode.stackqueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InBuiltExample {

    public static void main(String[] args) {
        //it's a class
        Stack<Integer> stack =new Stack<>();
        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.push(15);

        System.out.println(stack.peek());
        System.out.println(stack.pop());

        Queue<Integer> queue=new LinkedList<>();
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.remove());


    }
}
