package com.practice.mycodeschool.ds;



public class StackLinkedListImplementation_2 {

    public static Nodes topHead;

    public static void main(String[] args) {

        StackLinkedListImplementation_2 obj=new StackLinkedListImplementation_2();
        obj.push(10);
        obj.push(20);
        obj.push(30);

        obj.push(40);
        obj.push(50);
       // obj.display();

        obj.pop();
        obj.pop();
        obj.push(40);
        obj.display();

    }

    private void pop() {
        if(topHead!=null){
            topHead=topHead.next;
        }
    }

    private void display() {
        Nodes dummyHead=topHead;
        while(dummyHead!=null){
            System.out.println(dummyHead.data);
            dummyHead=dummyHead.next;
        }
    }

    private void push(int data) {
        Nodes newNode= new Nodes();
        newNode.data=data;
        newNode.next=topHead;
        topHead=newNode;
    }
}
