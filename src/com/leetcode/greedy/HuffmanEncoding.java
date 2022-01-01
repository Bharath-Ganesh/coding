package com.leetcode.greedy;

import java.util.*;

public class HuffmanEncoding {

    public static void main(String[] args) {
        HuffmanEncoding obj = new HuffmanEncoding();
        String word = "qwertyuiopasdfghjklzxcvbn";
        PriorityQueue<Integer> pq=new PriorityQueue<>();


    }

    class MinHeapNode {
        char ch;
        int freq;
        MinHeapNode left;
        MinHeapNode right;

        public MinHeapNode(char ch, int freq, MinHeapNode left, MinHeapNode right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> huffmanCodes(String word, int frequency[], int N) {
        // Code here
        List<String> huffmanCodes = new ArrayList<>();
        PriorityQueue<MinHeapNode> pq = new PriorityQueue<>((a, b) -> {
                    if(a.freq >= b.freq){
                        return 1;
                    }
                    return -1;
        });
        for (int i = 0; i < frequency.length; i++) {
            pq.add(new MinHeapNode(word.charAt(i), frequency[i], null, null));
        }

        while (pq.size() > 1) {
            MinHeapNode left = pq.poll();
            MinHeapNode right = pq.poll();
            int res = left.freq + right.freq;
            MinHeapNode newMinHeapNode = new MinHeapNode('$', res, left, right);
            pq.add(newMinHeapNode);
        }
        MinHeapNode rootNode = pq.poll();
        printHuffManCodes(rootNode, huffmanCodes, "");
        return huffmanCodes;
    }

    private void printHuffManCodes(MinHeapNode rootNode, List<String> huffmanCodes, String s) {
        if (rootNode == null) {
            return;
        }
        if (rootNode.ch != '$') {
            huffmanCodes.add(s);
            return;
        }
        printHuffManCodes(rootNode.left, huffmanCodes, s + "0");
        printHuffManCodes(rootNode.right, huffmanCodes, s + "1");
    }


}
