package com.leetcode.linkedlist;

public class ReverseKNodeInGroup {


    public static void main(String[] args) {
        ReverseKNodeInGroup obj = new ReverseKNodeInGroup();
        ListNode list1 = getLinkedNode();
        int k=1;
        display(obj.reverseKGroup(list1,k));
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        int length = findLength(head);
        int k1 = length / k;
        ListNode prev = null;
        ListNode curr = head;

        while(k1 > 0){
            ListNode newHead = prev;
            ListNode newEnd = curr;
            for(int i=0; curr!=null && i < k; i++){
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            if(newHead == null){
                head = prev;
            } else{
                newHead.next = prev;
            }
            newEnd.next = curr;
            prev = newEnd;
            k1--;
        }
        return head;
    }


    private int findLength(ListNode node){
        int length = 0;
        ListNode dummyHead = node;
        while(dummyHead!=null){
            dummyHead = dummyHead.next;
            length++;
        }
        return length;
    }

//    public static ListNode reverseKGroup(ListNode head, int k) {
//        int length=0;
//        ListNode dummyHead=head;
//        while(dummyHead!=null){
//            dummyHead=dummyHead.next;
//            length+=1;
//        }
//        int loop= length/k;
//        ListNode prev=null;
//        ListNode curr=head;
//        while(loop>0){
//            ListNode last=prev;
//            ListNode newEnd=curr;
//            for(int i=0;curr!=null && i<k;i++){
//                ListNode nextNode=curr.next;
//                curr.next=prev;
//                prev=curr;
//                curr=nextNode;
//            }
//            if(last==null){
//                head=prev;
//            }else{
//                last.next=prev;
//            }
//            newEnd.next=curr;
//            prev=newEnd;
//            loop--;
//        }
//        return head;
//    }

//    public static ListNode reverseKGroup(ListNode head, int k) {
//
//        if(k<=1 && head==null){
//            return head;
//        }
//        ListNode prev=null;
//        ListNode curr=head;
//        int length=findLength(head);
//        int loop=length/k;
//        while(true){
//            if(loop==0){
//                break;
//            }
//            ListNode last=prev;
//            ListNode newLast=curr;
//            for(int i=0;curr!=null && i<k;i++){
//                ListNode nextNode=curr.next;
//                curr.next=prev;
//                prev=curr;
//                curr=nextNode;
//            }
//
//            if(last!=null){
//                last.next=prev;
//            }else{
//                head=prev;
//            }
//
//            newLast.next=curr;
//            if(curr==null){
//                break;
//            }
//            prev=newLast;
//            loop--;
//        }
//        display(head);
//        return head;
//    }
//
//
//    public static int findLength(ListNode head){
//        int length=0;
//        while(head!=null){
//            length+=1;
//            head=head.next;
//        }
//        return length;
//    }

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


        return listNode1.head;
    }
}
