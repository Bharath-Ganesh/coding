package com.leetcode.trees.heaps;

import com.leetcode.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {

    public static void main(String[] args) {
        MergeKSortedLinkedLists obj = new MergeKSortedLinkedLists();
        ListNode[] res = new ListNode[3];
        ListNode[] res2 = new ListNode[3];
        ListNode first = first();
        ListNode second = second();
        ListNode third = third();
        res[0] = first;
        res[1] = second;
        res[2] = third;
        ListNode listNode = obj.mergeKLists(res2);
        obj.display(listNode);
    }

    private static ListNode first() {
        ListNode first = new ListNode(1);
        first.next = new ListNode(4);
        first.next.next = new ListNode(5);
        return first;
    }

    private static ListNode second() {
        ListNode first = new ListNode(1);
        first.next = new ListNode(3);
        first.next.next = new ListNode(4);
        return first;
    }

    private static ListNode third() {
        ListNode first = new ListNode(2);
        first.next = new ListNode(6);
        return first;
    }

    class Node {
        ListNode node;

        public Node(ListNode node) {
            this.node = node;
        }
    }

    public void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;
        Comparator<ListNode> c = new Comparator<ListNode>() {

            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        };
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(c);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.add(lists[i]);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode currNode = minHeap.remove();
            head.next = currNode;
            head = head.next;
            currNode = currNode.next;
            if (currNode != null) {
                minHeap.add(currNode);
            }
        }

        return dummyHead.next;
    }

//    public ListNode mergeKLists(ListNode[] list) {
//        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val>o2.val?1:-1);
//        if (list == null || list.length == 0) {
//            return null;
//        }
//        int k = list.length;
//        for (int i = 0; i < k; i++) {
//            if (list[i] != null) {
//                pq.add(list[i]);
//            }
//        }
//        ListNode head = pq.peek();
//        ListNode tail = head;
//        ListNode next = pq.remove().next;
//        if(next!=null){
//            pq.add(next);
//        }
//        while (!pq.isEmpty()) {
//            ListNode currNode = pq.remove();
//            tail.next = currNode;
//            tail = tail.next;
//            ListNode nextNode = currNode.next;
//            if (nextNode != null) {
//                pq.add(nextNode);
//            }
//        }
//        return head;
//    }
}
