package com.practice.mycodeschool.ds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackArrayImplementation_1 {

    int size=20;
    int[] stack= new int[size];
    int top= -1;

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        StackArrayImplementation_1 obj=new StackArrayImplementation_1();
        obj.push(10);
        obj.push(20);
        obj.push(30);
        obj.display();
        obj.push(40);
        obj.push(50);
        obj.display();
        obj.pop();
        obj.display();

    }

    private void pop() {
        if(top==-1){
            System.out.println("Empty stack");
            return;
        }
        top--;
    }

    private void display() {
        if (top==-1){
            System.out.println("No elements to be displayed");
            return;
        }
        int currentTop=top;
        while (top!=-1){
            System.out.println(stack[top--]);
        }
        top=currentTop;
    }

    private void push(int number) {
        if(size>=top){
            stack[++top]=number;
        }
    }


}
