package com.leetcode.stackqueues;

public class ImplementTwoStacksInAnArray {

    public static void main(String[] args) {
        ImplementTwoStacksInAnArray ImplementTwoStacksInAnArray = new ImplementTwoStacksInAnArray();
        ImplementTwoStacksInAnArray.operations();
    }

    private void operations() {
        Stacks stacks=new Stacks();
        TwoStack twoStack=new TwoStack();
        stacks.push1(2,twoStack);
        stacks.push1(3,twoStack);
        stacks.push2(4,twoStack);
        System.out.println(stacks.pop1(twoStack));
        System.out.println(stacks.pop2(twoStack));
        System.out.println(stacks.pop2(twoStack));
    }



    class TwoStack {

        int size;
        int top1, top2;
        int arr[] = new int[100];

        TwoStack() {
            size = 100;
            top1 = -1;
            top2 = size;
        }
    }

    class Stacks {
        //Function to push an integer into the stack1.
        void push1(int x, TwoStack sq) {
            if (sq.top1 < sq.top2 - 1) {
                sq.arr[++sq.top1] = x;
            }
        }

        //Function to push an integer into the stack2.
        void push2(int x, TwoStack sq) {
            if (sq.top2 > sq.top1 + 1) {
                sq.arr[--sq.top2] = x;
            }

        }

        //Function to remove an element from top of the stack1.
        int pop1(TwoStack sq) {
            int val = -1;
            if (sq.top1 != -1) {
                val = sq.arr[sq.top1--];
            }
            return val;
        }

        //Function to remove an element from top of the stack2.
        int pop2(TwoStack sq) {
            int val = -1;
            if (sq.top2 != sq.size) {
                val = sq.arr[sq.top2++];
            }
            return val;
        }
    }
}
