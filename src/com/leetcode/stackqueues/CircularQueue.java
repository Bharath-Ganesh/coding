package com.leetcode.stackqueues;

public class CircularQueue {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    private int front = -1;
    private int rear = -1;

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }


    public void add(int element) throws CustomQueueException {
        if (isFull()) {
            throw new CustomQueueException("Circular Queue is Full!!");
        }
        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
        } else if (rear == data.length - 1) {
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
        } else if (front == data.length - 1) {
            front = 0;
        } else {
            front++;
        }
        return element;

    }

    public int peek() throws CustomQueueException {
        if (isEmpty()) {
            throw new CustomQueueException("Queue is Empty!!");
        }
        int element = data[front];
        return element;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return;
        }
        int index = front;
        do {
            index = (index) % data.length;
            System.out.print(data[index] + " -> ");
            index += 1;
        } while ((index % data.length) != front);
        System.out.println("END");
    }


    public boolean isEmpty() {
        if (front == -1 && rear == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if ((front == 0 && rear == data.length - 1) || (front == rear + 1)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws CustomQueueException {
        CircularQueue circularQueue = new CircularQueue(5);
        circularQueue.add(12);
        circularQueue.add(13);
        circularQueue.add(14);
        circularQueue.add(15);
        circularQueue.add(16);
        // circularQueue.add(17);

        circularQueue.display();

        System.out.println("Remove " + circularQueue.remove());
        System.out.println("Remove " + circularQueue.remove());
        System.out.println("Peek " + circularQueue.peek());


            circularQueue.add(20);
            circularQueue.add(21);


        System.out.println("Remove " + circularQueue.remove());
        System.out.println("Remove " + circularQueue.remove());
        System.out.println("Remove " + circularQueue.remove());
        System.out.println("Peek " + circularQueue.peek());


        circularQueue.add(18);
        circularQueue.add(19);
        circularQueue.add(20);
        circularQueue.display();

    }
}
