package com.leetcode.stackqueues;

import java.util.Stack;

public class _012_MinStack {

    public static void main(String[] args) {



        _012_MinStack object = new _012_MinStack();
        object.push(2147483646);
        object.push(2147483646);
        object.push(2147483647);
        System.out.println(object.top());
        object.pop();
        System.out.println(object.getMin());
        object.pop();
        System.out.println(object.getMin());
        object.pop();
        object.push(2147483647);
        System.out.println(object.top());
        System.out.println(object.getMin());
        object.push(-2147483648);

        System.out.println(object.top());
        System.out.println(object.getMin());
        object.pop();
        System.out.println(object.getMin());
    }


    Stack<Long> stack;
    Long min;

    public _012_MinStack() {
        stack = new Stack();
        min = Long.MAX_VALUE;
    }

    private boolean empty() {
        return stack.isEmpty();
    }

    public void push(int val) {
        Long value=Long.valueOf(val);
        if (empty()) {
            min = value;
            stack.push(value);
            return;
        }
        if (val > min) {
            stack.push(value);
        } else {
            long mmin = 2 * value -  min;
            min = value;
            stack.push(mmin);
        }
    }

    public void pop() {
        if (empty()) {
            return;
        }
        long num = stack.pop();
        if (num < min) {
            min = 2 * (min) - num;
        }
    }

    public int top() {
        if (empty()) {
            return -1;
        }
        Long num = stack.peek();
        if (num >= min) {
            return num.intValue();
        } else {
            return min.intValue();
        }
    }

    public int getMin() {
        if (stack.empty()) {
            return -1;
        }
        return min.intValue();
    }


}
//    Stack<Long> stack;
//    private static Long min;
//
//    public _012_MinStack() {
//        stack = new Stack<>();
//        min = Long.MAX_VALUE;
//    }
//
//    public void push(int val) {
//        Long element = Long.valueOf(val);
//        if (stack.empty()) {
//            min = element;
//        }
//        if (val < min) {
//            element = 2 * element - min;
//            min = Long.valueOf(val);
//        }
//        stack.push(element);
//    }
//
//    public void pop() {
//        Long val = stack.pop();
//        if (val < min) {
//            min = 2 * min - val;
//        }
//    }
//
//    public int top() {
//        Long val = stack.peek();
//        if (val < min) {
//            return min.intValue();
//        }
//        return val.intValue();
//    }
//
//    public int getMin() {
//        return min.intValue();
//    }

