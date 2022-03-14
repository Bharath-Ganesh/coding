package com.leetcode.linkedlist;

public class FindIntersection {

    public static void main(String[] args) {
        ListNode list1 = getLinkedNode1();
        ListNode list2 = getLinkedNode2();
        ListNode result = findIntersection(list1,list2);
        display(result);
    }

    public static ListNode findIntersection(ListNode head1, ListNode head2)
    {
        // code here.
        ListNode dummyHead1=head1;
        ListNode dummyHead2=head2;

        ListNode dummyHead=new ListNode(-1);
        ListNode currHead=dummyHead;

        while(dummyHead1!=null && dummyHead2!=null){
            if(dummyHead1.val > dummyHead2.val){
                dummyHead2=dummyHead2.next;
            }else if(dummyHead1.val < dummyHead2.val){
                dummyHead1=dummyHead1.next;
            }else{
                currHead.next=dummyHead1;
                dummyHead1=dummyHead1.next;
                dummyHead2=dummyHead2.next;
                currHead=currHead.next;
            }
        }
        if(currHead!=null){
            currHead.next=null;
        }
        return dummyHead.next;
    }

    static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();

    }

    private static ListNode getLinkedNode1() {
        LinkedNode listNode1 = new LinkedNode();
        listNode1.addNode(1);
        listNode1.addNode(2);
        listNode1.addNode(3);
        listNode1.addNode(4);
        listNode1.addNode(6);
        return listNode1.head;
    }

    private static ListNode getLinkedNode2() {
        LinkedNode listNode1 = new LinkedNode();
        listNode1.addNode(2);
        listNode1.addNode(4);
        listNode1.addNode(6);
        listNode1.addNode(8);
        return listNode1.head;
    }
}
