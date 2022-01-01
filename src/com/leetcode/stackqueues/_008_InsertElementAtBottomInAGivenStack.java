package com.leetcode.stackqueues;

import java.util.Stack;

public class _008_InsertElementAtBottomInAGivenStack {

    public static void main(String[] args) {
        Stack <Integer> myStack=new Stack<>();
        myStack.push(7);
        myStack.push(1);
        myStack.push(4);
        myStack.push(5);
        pushAtBottom(myStack,9);

    }

    public static Stack<Integer> pushAtBottom(Stack <Integer> myStack, int element)
    {
        // Write your code here
        if(myStack.isEmpty()){
            myStack.push(element);
            return myStack;
        }

        int top=myStack.peek();
        myStack.pop();
        pushAtBottom(myStack,element);
        myStack.push(top);
        return myStack;
    }
}
