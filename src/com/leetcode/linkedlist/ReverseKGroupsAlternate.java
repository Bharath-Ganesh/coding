package com.leetcode.linkedlist;

public class ReverseKGroupsAlternate {


    public static void main(String[] args) {
        ListNode list1 = getLinkedNode();
        int k=2;
        System.out.println(reverseKNode(list1,k));
    }


    public static ListNode reverseKNode(ListNode head, int k)
    {

        //reverse the first k node
        if(head==null){
            return head;
        }
        ListNode curr=head;
        ListNode prev=null;
        for(int i=0;curr!=null && i<k;i++){
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        head.next=reverseKNode(curr,k);
        return prev;
    }


    public static ListNode reverseKGroup(ListNode head, int k) {

        if(k<=1 && head==null){
            return head;
        }

        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){

            ListNode last=prev;
            ListNode newLast=curr;
            for(int i=0;curr!=null && i<k;i++){
                ListNode nextNode=curr.next;
                curr.next=prev;
                prev=curr;
                curr=nextNode;
            }

            if(last!=null){
                last.next=prev;
            }else{
                head=prev;
            }

            newLast.next=curr;

            for(int i=0;curr!=null && i<k;i++){
                prev=curr;
                curr=curr.next;
            }
        }
        display(head);
        return head;
    }


    public static int findLength(ListNode head){
        int length=0;
        while(head!=null){
            length+=1;
            head=head.next;
        }
        return length;
    }

    static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();

    }

    private static ListNode getLinkedNode() {
        LinkedNode listNode1 = new LinkedNode();
        listNode1.addNode(1);
        listNode1.addNode(2);
        listNode1.addNode(3);
        listNode1.addNode(4);
        listNode1.addNode(5);
        listNode1.addNode(6);
        listNode1.addNode(7);
        listNode1.addNode(8);
        return listNode1.head;
    }
}
