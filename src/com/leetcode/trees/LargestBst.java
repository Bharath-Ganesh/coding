package com.leetcode.trees;

public class LargestBst {

    public static void main(String[] args) {
        LargestBst obj=new LargestBst();
        Node node = createNode();
        int n = largestBst(node);
        System.out.println(n);
    }

    private static Node createNode() {
        Node root = new Node(7);
        root.left = new Node(4);
        root.right = new Node(6);
        root.left.right = new Node(9);
        return root;
    }

    static class TreeNode{

        int max;
        int min;
        int size;

        public TreeNode(int min,int max,int size){
            this.max=max;
            this.min=min;
            this.size=size;
        }
    }

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        return largestBinaryTree(root).size;

    }

    static TreeNode largestBinaryTree(Node root)
    {
        // Write your code here

        if(root==null){
            return new TreeNode(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }

        TreeNode left=largestBinaryTree(root.left);
        TreeNode right=largestBinaryTree(root.right);

        if(left.max <root.data && root.data <right.min){

            return new TreeNode(Math.min(left.min,root.data),Math.max(root.data,right.max),left.size+right.size+1);
        }

        return new TreeNode(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.size,right.size));
    }
}
