package com.leetcode.linkedlist;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 */
public class MiddleOfTheLinkedList_6 {

    private static ListNode getLinkedNode() {
        LinkedNode listNode1 = new LinkedNode();
        listNode1.addNode(1);
        listNode1.addNode(2);
        listNode1.addNode(3);
        listNode1.addNode(4);
        listNode1.addNode(5);


        return listNode1.head;
    }

    static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        ListNode head = getLinkedNode();
        ListNode slowHead = middleNode(head);
        display(slowHead);

    }


    public static ListNode middleNode(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }
}
