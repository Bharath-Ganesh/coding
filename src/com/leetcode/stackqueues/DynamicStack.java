package com.leetcode.stackqueues;

public class DynamicStack extends CustomStack {

    public DynamicStack() {
        super();
    }
    public DynamicStack(int size) {
        super(size);
    }

    @Override
    public void push(int element) throws StackException {
        if(this.isFull()){
            int temp[]=new int[data.length*2];

            for(int i=0;i<data.length;i++){
                temp[i]=data[i];
            }
            data=temp;
        }
        super.push(element);
    }
}
