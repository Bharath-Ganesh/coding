package com.leetcode.stackqueues;


import java.util.HashMap;
import java.util.Map;

public class NewLfuCache {

}

class LFUCache {

    Map<Integer, Node> cache;
    Map<Integer, DLL> freqMap;
    int size;
    int minFrequency;

    public LFUCache(int capacity) {
        this.size = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            update(node);
            return node.val;
        }
        return -1;
    }

    private void update(Node node) {
        int freq = node.freq;
        DLL freqList = freqMap.get(freq);
        freqList.remove(node);

        if (freq == minFrequency && freqList.length == 0) {
            minFrequency++;
        }
        //increment freq by 1;
        node.freq++;
        DLL newFreqList = freqMap.getOrDefault(node.freq, new DLL());
        newFreqList.add(node);
        freqMap.put(node.freq, newFreqList);
    }

    public void put(int key, int value) {

        if (size == 0) return;

        if (cache.containsKey(key)) {
            Node currNode = cache.get(key);
            currNode.val = value;
            update(currNode);
        } else {
            // remove the tail node from minFreq
            if (cache.size() == size) {
                DLL minFreqList = freqMap.get(minFrequency);
                Node nodeToBeRemoved = minFreqList.tail.prev;
                minFreqList.remove(nodeToBeRemoved);
            }

            minFrequency = 1;
            DLL minFreqList = freqMap.getOrDefault(minFrequency, new DLL());
            Node newNode = new Node(key, value);
            minFreqList.add(newNode);
            freqMap.put(minFrequency,minFreqList);
        }
    }

    class DLL {

        Node head;
        Node tail;
        int length;

        public DLL() {
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            this.head.next = tail;
            this.tail.prev = head;
            this.length = 0;
        }

        public void add(Node currNode) {
            cache.put(currNode.key, currNode);
            Node secondNode = head.next;
            head.next = currNode;
            currNode.prev = head;
            currNode.next = secondNode;
            secondNode.prev = currNode;
            this.length += 1;
        }

        public void remove(Node currNode) {
            cache.remove(currNode.key);
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            this.length -= 1;
        }

    }

    class Node {

        Node next;
        Node prev;
        int key;
        int val;
        int freq;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }


    public static void main(String[] args) {


        LFUCache lfu = new LFUCache(2);
        lfu.put(10, 13);
        lfu.put(3, 17);
        lfu.put(6, 11);
        lfu.put(10, 5);
        lfu.put(9, 10);
        System.out.println(lfu.get(13));
        lfu.put(2, 19);
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(3));
        lfu.put(5, 25);
        System.out.println(lfu.get(8));
        lfu.put(9, 22);
        lfu.put(5, 8);
        lfu.put(5, 25);
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

