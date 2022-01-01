package com.leetcode.stackqueues;

public class DynamicQueue extends CustomQueue{

    public DynamicQueue() {
        super();
    }
    public DynamicQueue(int size) {
        super(size);
    }

    @Override
    public void add(int element) throws CustomQueueException {
        if(this.isFull()){
            int temp[]=new int[data.length*2];

            for(int i=0;i<data.length;i++){
                temp[i]=data[i];
            }
            data=temp;
        }
        super.add(element);
    }
}
