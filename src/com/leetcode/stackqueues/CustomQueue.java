package com.leetcode.stackqueues;

public class CustomQueue {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    private int front = -1;
    private int rear = -1;

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }


    public void add(int element) throws CustomQueueException {
        if (isFull()) {
            throw new CustomQueueException("Queue is Full!!");
        }
        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
        } else {
            rear++;
        }
        data[rear] = element;
    }

    public int remove() throws CustomQueueException {
        if (isEmpty()) {
            throw new CustomQueueException("Queue is Empty!!");
        }
        int element = data[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }
        return element;
    }

    public int peek() throws CustomQueueException {
        if (isEmpty()) {
            throw new CustomQueueException("Queue is Empty!!");
        }
        return data[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return;
        }
        for (int i = 0; i <= front; i++) {
            System.out.print(data[i] + " -> ");
        }
        System.out.println("END");
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        if (rear == data.length - 1) {
            return true;
        }
        return false;
    }
}
