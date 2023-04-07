package com.leetcode.trees.heaps;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class IsBinaryTreeHeap {

    public static void main(String[] args) {
        IsBinaryTreeHeap obj = new IsBinaryTreeHeap();
        Node root = extracted();
        boolean heap = obj.isHeap(root);
        System.out.println(heap);
    }

    private static Node extracted() {
        Node root = new Node(8);
        root.left = new Node(7);
        root.right = new Node(6);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        return root;
    }

    public boolean isHeap(Node tree) {
        // code here
        if (tree == null) {
            return true;
        }
        String result = "";
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currNode = queue.remove();
                if (currNode == null) {
                    result += null + ",";
                    continue;
                } else {
                    list.add(currNode.data);
                }
                result += currNode.data + ",";
                queue.add(currNode.left);
                queue.add(currNode.right);
            }
        }

        return utilMaxHeap(list) && completeBinaryTree(result);

    }

    private boolean completeBinaryTree(String result) {
        String[] split = result.split(",");
        int nullIndex = result.length();
        int numberIndex = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("null")) {
                nullIndex = i;
            } else {
                numberIndex = i;
            }
            if (nullIndex < numberIndex) {
                return false;
            }
        }
        return true;
    }

    public boolean utilMaxHeap(List<Integer> list) {
        Integer prev = null;
        for (Integer element : list) {
            if (prev == null) {
                prev = element;
            }
            if (element > prev) {
                return false;
            }
        }
        return true;
    }
}
