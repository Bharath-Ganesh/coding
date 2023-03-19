package com.leetcode.stackqueues;

public class QueueMain {

    public static void main(String[] args) throws CustomQueueException {
//        CustomQueue queue = new CustomQueue(5);
//        queue.add(12);
//        queue.add(13);
//        queue.add(14);
//        queue.add(15);
//        queue.add(16);
//        queue.display();
//        System.out.println("Peek -> " + queue.peek());
//        System.out.println("Remove -> " +queue.remove());
//        System.out.println("Remove -> " +queue.remove());
//
//
//        queue.add(17);
//        queue.add(18);
//        queue.add(11);
//        queue.display();


        DynamicQueue queue1 = new DynamicQueue(5);
        queue1.add(12);
        queue1.add(13);
        queue1.add(14);
        queue1.add(15);
        queue1.add(16);
        queue1.display();
        System.out.println("Peek -> " + queue1.peek());
        System.out.println("Remove -> " +queue1.remove());
        System.out.println("Remove -> " +queue1.remove());


        queue1.add(17);
        queue1.add(18);
        queue1.add(11);
        queue1.display();




    }
}
