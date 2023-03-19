package com.leetcode.stackqueues;

import java.util.Stack;

/**
 * https://www.codingninjas.com/codestudio/problems/sort-a-stack_985275?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 */
public class SortStack {

    public static void main(String[] args) {
        SortStack obj = new SortStack();
        Stack stack = new Stack();
        //5 -2 9 -7 3
        stack.push(5);
        stack.push(-2);
        stack.push(9);
        stack.push(-7);
        stack.push(3);
        sortStack(stack);
    }

    public static void sortStack(Stack<Integer> stack) {
        // Write your code here.

        if (stack.isEmpty()) {
            return;
        }

        int element = stack.pop();
        sortStack(stack);
        insertElement(stack, element);
    }

    public static void insertElement(Stack<Integer> stack, int element) {
        Stack<Integer> s2 = new Stack<>();
        while (!stack.isEmpty() && stack.peek() >= element) {
            s2.push(stack.pop());
        }
        stack.push(element);

        while (!s2.isEmpty()) {
            stack.push(s2.pop());
        }

    }
}
