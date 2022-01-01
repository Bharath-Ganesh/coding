package com.leetcode.stackqueues;

public class CustomStack {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    private int ptr = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    public void push(int element) throws StackException {
        if (isFull()) {
            throw new StackException("Stack is Full!!");
        }
        data[++ptr] = element;
    }


    public int pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Cannot pop from an empty stack!!");
        }
        return data[ptr--];
    }

    public int peek() throws StackException {
        if (isFull()) {
            throw new StackException("Cannot peek from an empty stack!!");
        }
        return data[ptr];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        for (int i = 0; i <=ptr; i++) {
            System.out.print(data[i] + " -> ");
        }
        System.out.println("END");
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }
}
