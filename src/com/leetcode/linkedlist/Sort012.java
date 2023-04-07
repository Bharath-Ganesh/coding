package com.leetcode.linkedlist;

public class Sort012 {

    public static void main(String[] args) {
        ListNode list1 = getLinkedNode();
        ListNode result = segregate(list1);
        display(result);
    }

    static ListNode segregate(ListNode head)
    {
        // add your code here
        int countZero=0;
        int countOne=0;
        int countTwo=0;

        ListNode curr=head;
        while(curr!=null){
            if(curr.val==0){
                countZero+=1;
            }else if(curr.val==1){
                countOne+=1;
            }else{
                countTwo+=1;
            }
            curr=curr.next;
        }

        curr=head;
        for(int i=0;curr!=null && i<countZero;i++){
            curr.val=0;
            curr=curr.next;
        }

        for(int i=0;curr!=null && i<countOne;i++){
            curr.val=1;
            curr=curr.next;
        }

        for(int i=0;curr!=null && i<countTwo;i++){
            curr.val=2;
            curr=curr.next;
        }
        return head;
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
        listNode1.addNode(2);
        listNode1.addNode(1);
        listNode1.addNode(2);
        listNode1.addNode(0);
        listNode1.addNode(2);
        listNode1.addNode(2);
        return listNode1.head;
    }
}
