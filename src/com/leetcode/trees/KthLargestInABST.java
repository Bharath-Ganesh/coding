package com.leetcode.trees;

import java.util.Stack;

public class KthLargestInABST {

    public static void main(String[] args) {
        KthLargestInABST obj = new KthLargestInABST();
        TreeNode root = obj.createNode();
        System.out.println(obj.kthLargest(root, 3));
    }

    private TreeNode createNode() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        return root;
    }

    public int kthLargest(TreeNode root, int k) {
        //Your code here
        if (root == null) {
            return -1;
        }
        int n = countNode(root);
        k = n - k + 1;
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }

    public int countNode(TreeNode root) {

        if (root == null) return 0;

        return 1 + countNode(root.left) + countNode(root.right);
    }
}
