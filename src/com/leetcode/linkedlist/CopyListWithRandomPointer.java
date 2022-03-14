package com.leetcode.linkedlist;


public class CopyListWithRandomPointer {

    public static void main(String[] args) {
        CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();
        copyListWithRandomPointer.createNodeWithRandom();
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private void createNodeWithRandom() {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;


        Node head=copyRandomList(node1);
        display(head);
    }

    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();

    }


    public Node copyRandomList(Node head) {

        if(head==null){
            return head;
        }
        Node curr=head;
        while(curr!=null){
            Node newNode=new Node(curr.val);
            newNode.next=curr.next;
            curr.next=newNode;
            curr=curr.next.next;
        }

        curr=head;
        while(curr!=null){
            //curr.next.random=curr.random.next;
            if(curr.next != null){
                curr.next.random = (curr.random!= null) ? curr.random.next : null;
            }
            curr=curr.next.next;
        }


        Node dummyHead=new Node(-1);
        Node temp=dummyHead;
        Node prevNode=head;
        curr=head.next.next;

        while(prevNode!=null){
            temp.next=prevNode.next;
            prevNode.next=curr;
            prevNode=curr;
            if(curr!=null && curr.next!=null){
                curr=curr.next.next;
            }
            temp=temp.next;
        }
        return dummyHead.next;

    }


}
