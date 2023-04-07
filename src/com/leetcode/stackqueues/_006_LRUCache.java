package com.leetcode.stackqueues;

import java.util.*;

public class _006_LRUCache {

    public static void main(String[] args) {
        Deque<Integer> deq=new LinkedList<>();

        _006_LRUCache obj = new _006_LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        obj.put(3, 3);
        System.out.println(obj.get(2));
        obj.put(4, 4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));

    }

    Map<Integer,Node> cache=new HashMap<>();
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int capacity;

    public _006_LRUCache(int capacity) {
        this.capacity=capacity;
        this.head.next=tail;
        this.tail.prev=head;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node node=cache.get(key);
            delete(node);
            add(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node newNode=new Node(key,value);
        if(cache.containsKey(key)){
            delete(cache.get(key));
        }
        if(capacity==cache.size()){
            delete(tail.prev);
        }
        add(newNode);
    }


    public void add(Node node){
        Node secondHead=head.next;
        head.next=node;
        node.prev=head;
        node.next=secondHead;
        secondHead.prev=node;
        cache.put(node.key,node);
    }

    public void delete(Node node){
        cache.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }


    class Node {

        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
}
