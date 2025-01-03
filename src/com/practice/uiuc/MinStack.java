package com.practice.uiuc;

import java.util.Stack;
import java.util.stream.IntStream;

public class MinStack {

    public static void main(String[] args) {
        String someString = "123123";
        boolean isNumeric = someString.chars().allMatch(Character :: isDigit);
        System.out.println(isNumeric);

        MinStack obj = new MinStack();
        obj.operations();
    }

    private void operations() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin());
    }

    Stack<Long> stack;
    Long min = Long.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            min = Long.valueOf(val);
            stack.push(min);
            return;
        }
        // we have to update the minValue
        long new_min;
        if(val < min){
            new_min = 2 * (long) val - min;
            min = Long.valueOf(val);
        }else {
            new_min = Long.valueOf(val);
        }
        stack.push(new_min);
    }

    public void pop() {
        String word = "a";
         word.chars();

        if(stack.isEmpty()) return;
        long topElement = stack.pop();
        // updated minValue
        long topValue;
        if(topElement < min){
            topValue = 2 * min - topElement;
            min = topValue;
        }
    }

    public int top() {
        if(stack.isEmpty()) return -1;
        long topElement = stack.peek();
        // updated minValue
        long topValue;
        if(topElement < min){
            topValue = min;
        }else {
            topValue = stack.peek();
        }
        return (int) topValue;
    }

    public int getMin() {
        if(stack.isEmpty()) return -1;
        return Integer.valueOf(String.valueOf(min));
    }
}
