package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MorrisTraversal {

    public static void main(String[] args) {
        MorrisTraversal obj = new MorrisTraversal();
        TreeNode root = obj.createNode();
        System.out.println(obj.inorderTraversal(root));
        System.out.println(obj.morrisTraversal(root));
    }

    private TreeNode createNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        return root;
    }

    public List<Integer> inorderTraversal(TreeNode root) {


        List<Integer> inorder = new ArrayList<>();
        if (root == null) {
            return inorder;
        }
        Stack<TreeNode> treeStack = new Stack<>();
        TreeNode curr = root;
        while (!treeStack.isEmpty() || curr != null) {
            if (curr != null) {
                treeStack.push(curr);
                curr = curr.left;
            } else {
                curr = treeStack.pop();
                inorder.add(curr.val);
                curr = curr.right;
            }
        }
        return inorder;

    }

    public static List<Integer> morrisTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr=curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = curr;
                    curr=curr.left;
                } else {
                    prev.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}
