package com.leetcode.stackqueues;

public class Main {

    public static void main(String[] args) throws StackException {
        DynamicStack dynamicStack = new DynamicStack(5);
        dynamicStack.push(12);
        dynamicStack.push(13);
        dynamicStack.push(14);
        dynamicStack.push(16);
        dynamicStack.push(17);
        dynamicStack.push(18);
        dynamicStack.push(19);
        dynamicStack.display();


        System.out.println(dynamicStack.pop());
        System.out.println(dynamicStack.pop());
        System.out.println(dynamicStack.pop());
        System.out.println(dynamicStack.pop());
        System.out.println(dynamicStack.pop());
      //  System.out.println(customStack.pop());

        dynamicStack.display();


    }
}
