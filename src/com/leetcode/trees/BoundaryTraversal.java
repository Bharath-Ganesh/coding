package com.leetcode.trees;

import java.util.*;
import java.util.stream.Collectors;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
    }
}

public class BoundaryTraversal {

    public static void main(String[] args) {
        BoundaryTraversal obj = new BoundaryTraversal();
        Node root = obj.createNode3();
        System.out.println(obj.inorderTraversal(root));
        System.out.println(obj.boundary(root));

    }

    //3 5 2 4 7 6 N 2 4 5 2 6 6 N 7 4 1 4 4 1 N 1 7
    private Node createNode3() {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.right.left = new Node(6);
        root.right.left.left = new Node(6);
        root.right.left.right = new Node(6);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(4);

        // root.left.left.left.left = new Node(1);
        root.left.left.left.right = new Node(7);

        root.left.left.right.left = new Node(4);
        root.left.left.right.right = new Node(1);

        root.left.right.right = new Node(2);
        root.left.right.left = new Node(5);

        root.left.right.left.left = new Node(4);
        root.left.right.left.right = new Node(4);

        root.left.right.right.left = new Node(1);

        root.right.left.left.left = new Node(1);
        root.right.left.left.right = new Node(7);
        return root;
    }

    private Node createNode2() {
        Node root = new Node(17);
        root.right = new Node(1);
        root.right.right = new Node(9);
        root.right.right.right = new Node(2);
        root.right.right.right.right = new Node(11);
        root.right.right.right.right.right = new Node(16);
        root.right.right.right.right.right.right = new Node(8);
        root.right.right.right.right.right.right.right = new Node(5);
        return root;
    }

    private Node createNode() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(5);
        root.left.left = new Node(4);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right = new Node(3);
        root.right.right = new Node(7);
        root.right.left = new Node(6);
        return root;
    }

    ArrayList<Integer> boundary(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (!isLeaf(root)) {
            res.add(root.data);
        }
        addLeftBoundary(root.left, res);
        addLeaves(root, res);
        addRightBoundary(root.right, res);
        return res;
    }

    Boolean isLeaf(Node root) {
        return (root.left == null) && (root.right == null);
    }


    void addLeftBoundary(Node root, ArrayList<Integer> res) {
        if (root == null || isLeaf(root)) {
            return;
        }
        res.add(root.data);
        if (root.left != null) {
            addLeftBoundary(root.left, res);
        } else if (root.right != null) {
            addLeftBoundary(root.right, res);
        }
    }

    void addRightBoundary(Node root, ArrayList<Integer> res) {
        if (root == null || isLeaf(root)) {
            return;
        }
        if (root.right != null) {
            addRightBoundary(root.right, res);
        } else if (root.left != null) {
            addRightBoundary(root.left, res);
        }
        res.add(root.data);

    }

    void addLeaves(Node root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        addLeaves(root.left, res);
        if (isLeaf(root)) {
            res.add(root.data);
        }
        addLeaves(root.right, res);
    }

    Boolean isLeafIterative(Node root) {
        return (root.left == null) && (root.right == null);
    }

    ArrayList<Integer> boundaryIterative(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (!isLeafIterative(root)) {
            res.add(root.data);
        }
        addLeftBoundaryIterative(root, res);
        addLeavesIterative(root, res);
        addRightBoundaryIterative(root, res);
        return res;
    }


    void addLeftBoundaryIterative(Node root, ArrayList<Integer> res) {
        // You'll have to go left as possible
        Node cur = root.left;
        while (cur != null) {
            if (isLeafIterative(cur) == false) {
                res.add(cur.data);
            }
            if (cur.left != null) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
    }

    void addRightBoundaryIterative(Node root, ArrayList<Integer> res) {
        Node cur = root.right;
        ArrayList<Integer> tmp = new ArrayList<>();
        while (cur != null) {
            if (isLeafIterative(cur) == false) {
                tmp.add(cur.data);
            }
            if (cur.right != null){
                cur = cur.right;
            }
            else {
                cur = cur.left;
            }
        }
        int i;
        for (i = tmp.size() - 1; i >= 0; --i) {
            res.add(tmp.get(i));
        }
    }

    void addLeavesIterative(Node root, ArrayList<Integer> res) {
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map=new TreeMap<>();
        if(root==null){
            return;
        }
        if (isLeafIterative(root)) {
            res.add(root.data);
            return;
        }
        addLeavesIterative(root.left, res);
        addLeavesIterative(root.right, res);
    }

    public List<Integer> inorderTraversal(Node root) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue>> map=new TreeMap<>();
        for(Map.Entry<Integer,TreeMap<Integer,PriorityQueue>> s : map.entrySet()){
            TreeMap<Integer, PriorityQueue> value = s.getValue();
        }

        List<Integer> inorder = new ArrayList<>();
        if (root == null) {
            return inorder;
        }
        Stack<Node> treeStack = new Stack<>();
        Node curr = root;
        while (!treeStack.isEmpty() || curr != null) {
            if (curr != null) {
                treeStack.push(curr);
                curr = curr.left;
            } else {
                curr = treeStack.pop();
                inorder.add(curr.data);
                curr = curr.right;
            }
        }
        return inorder;

    }



}
