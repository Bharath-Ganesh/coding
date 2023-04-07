package com.leetcode.linkedlist;

public class CountTripletsInSortedDoublyLinkedList {

    public static void main(String[] args) {
        DLL doubleLinkedList = getLinkedNode();
        DLL.Node head = doubleLinkedList.head;
        head.prev = null;
        int x = 17;
        System.out.println("count = " + countTriplets(head, x));
        display(head);

    }

    static int countTriplets(DLL.Node head, int sum) {
        int count = 0;
        DLL.Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        // lastNode
        DLL.Node tail = curr;
        curr = head;
        while (curr != null) {
            if (curr.prev == null || (curr.prev != null && curr.prev.val != curr.val)) {
                int reqSum = sum - curr.val;
                DLL.Node nextPointer = curr.next;
                DLL.Node lastPointer = tail;
                while (nextPointer != null && lastPointer != null && nextPointer != lastPointer) {
                    int currSum = nextPointer.val + lastPointer.val;
                    if (currSum == reqSum) {
                        count += 1;
                        System.out.println("(" + curr.val + "," + nextPointer.val + "," + lastPointer.val + ")");
                        while (nextPointer != null && nextPointer.next != null && nextPointer.val == nextPointer.next.val) {
                            nextPointer = nextPointer.next;
                        }

                        while (lastPointer != null && lastPointer.prev != null && lastPointer.val == lastPointer.prev.val) {
                            lastPointer = lastPointer.prev;
                        }
                        nextPointer = nextPointer.next;
                        lastPointer = lastPointer.prev;
                    } else if (currSum > reqSum) {
                        lastPointer = lastPointer.prev;
                    } else {
                        nextPointer = nextPointer.next;
                    }
                }
            }
            curr = curr.next;
        }
        // required count of triplets
        return count;
    }


    private static DLL getLinkedNode() {
        DLL listNode1 = new DLL();
        listNode1.insertLast(1);
        listNode1.insertLast(1);
        listNode1.insertLast(1);
        listNode1.insertLast(1);
        listNode1.insertLast(2);
        listNode1.insertLast(2);
        listNode1.insertLast(2);
        listNode1.insertLast(4);
        listNode1.insertLast(4);
        listNode1.insertLast(4);
        listNode1.insertLast(5);
        listNode1.insertLast(6);
        listNode1.insertLast(8);
        listNode1.insertLast(8);
        listNode1.insertLast(8);
        listNode1.insertLast(8);
        listNode1.insertLast(9);
        listNode1.insertLast(9);
        listNode1.insertLast(9);
        return listNode1;
    }

    /**
     * Display elements of the linked list
     */
    public static void display(DLL.Node head) {
        DLL.Node node = head;
        DLL.Node last = null;
        while (node != null) {
            System.out.print(node.val + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        System.out.println("Print in reverse");
        while (last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }
}
