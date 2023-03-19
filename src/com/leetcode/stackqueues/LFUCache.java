//package com.leetcode.stackqueues;
//
//import java.util.HashMap;
//import java.util.Map;
//
//class LFUCache {
//
//    Map<Integer,DoublyLinkedList> freqMap;
//    Map<Integer,Node> cache;
//    int capacity;
//    int size;
//    int minFreq;
//
//    public LFUCache(int capacity) {
//        freqMap=new HashMap<>();
//        cache=new HashMap<>();
//        this.capacity=capacity;
//        this.size=0;
//        this.minFreq=0;
//    }
//
//    public int get(int key) {
//        //Get function
//        if(cache.containsKey(key)){
//            Node currNode=cache.get(key);
//            updateNode(currNode);
//            return currNode.val;
//        }else{
//            return -1;
//        }
//    }
//
//    public void put(int key, int value) {
//
//        // corner case: check cache capacity initialization
//        if(capacity==0){
//            return;
//        }
//
//        //if the cache contains the key
//        //increase the frequency and remove from the existing DLL
//        // create a new DLL, or the DLL with same freq
//        if(cache.containsKey(key)){
//            Node currNode=cache.get(key);
//            currNode.val=value;
//            // In the cache we are re-assigning the value of the currNode with the update value
//            updateNode(currNode);
//        }else{
//            size++;
//            if(capacity < size){
//                DoublyLinkedList minFreqList=freqMap.get(minFreq);
//                //remove the element from the cache and freqList
//                Node nodeToRemoved=minFreqList.tail.prev;
//                cache.remove(nodeToRemoved.key);
//                minFreqList.remove(nodeToRemoved);
//                size--;
//            }
//
//            //increase the currListSize
//
//            //since this is a new element
//            minFreq=1;
//            Node newNode=new Node(key,value);
//
//            DoublyLinkedList currList=freqMap.getOrDefault(1,new DoublyLinkedList());
//
//            //insert the value in the head of the DLL
//            currList.insert(newNode);
//            freqMap.put(1,currList);
//            //update the value in the map too
//            cache.put(key,newNode);
//
//        }
//    }
//
//
//    public void updateNode(Node currNode){
//        Integer freq=currNode.freq;
//        DoublyLinkedList currList=freqMap.get(freq);
//        currList.remove(currNode);
//
//
//        //minFrequency needs be updated if the DLL size is 0
//        //and the currFrequency is equal to the minFreq
//        if(minFreq==freq && currList.listSize==0){
//            minFreq++;
//        }
//        //increase the frequency
//        currNode.freq++;
//
//        DoublyLinkedList newList=freqMap.getOrDefault(currNode.freq,new DoublyLinkedList());
//        newList.insert(currNode);
//        freqMap.put(freq+1,newList);
//
//        //why don't we need the below method?
//        // in get the value of the node is not getting changed
//        //in put, the value of the node is getting updated and since the object val is changed in the heap
//        //it reflects
//        //cache.put(currNode.key,currNode);
//    }
//
//    class DoublyLinkedList{
//
//        Node head;
//        Node tail;
//        int listSize;
//
//        public DoublyLinkedList() {
//            this.head=new Node(0,0);
//            this.tail=new Node(0,0);
//            head.next=tail;
//            tail.prev=head;
//            this.listSize=0;
//        }
//
//        public void insert(Node currNode){
//            Node secondHead=head.next;
//            currNode.next=secondHead;
//            currNode.prev=head;
//            head.next=currNode;
//            secondHead.prev=currNode;
//            listSize++;
//        }
//
//        public void remove(Node currNode){
//            currNode.prev.next=currNode.next;
//            currNode.next.prev=currNode.prev;
//            listSize--;
//        }
//
//    }
//
//
//    class Node{
//        Node next;
//        Node prev;
//        int key;
//        int val;
//        int freq;
//
//        public Node(int key,int val){
//            this.key=key;
//            this.val=val;
//            this.freq=1;
//        }
//    }
//
//    public static void main(String[] args) {
//        LFUCache lfu = new LFUCache(2);
//        lfu.put(1, 1);
//        lfu.put(2, 2);
//        lfu.put(2, 3);
//        System.out.println(lfu.get(1));
//        lfu.put(3, 3);
//        System.out.println(lfu.get(2));
//        System.out.println(lfu.get(3));
//        lfu.put(4, 4);
//        System.out.println(lfu.get(1));
//        System.out.println(lfu.get(3));
//        System.out.println(lfu.get(4));
//    }
//}
//
//
