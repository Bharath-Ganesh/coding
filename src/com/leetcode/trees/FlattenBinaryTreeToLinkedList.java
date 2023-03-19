package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {


    public static void main(String[] args) {

        FlattenBinaryTreeToLinkedList obj = new FlattenBinaryTreeToLinkedList();
        TreeNode root = obj.createNode();
        obj.flattenMorris(root);
        System.out.println(obj.inorderTraversal(root));
    }

    private TreeNode createNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        return root;
    }

    public void flatten(TreeNode root, TreeNode prev) {
        if (root == null) {
            return;
        }
        flatten(root.right, prev);
        flatten(root.left, prev);
        root.right = prev;
        root.left = null;
    }


    public void flatten(TreeNode root) {
        TreeNode prev = null;
        flatten(root, prev);
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

    public void flattenMorris(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                curr = curr.right;
            } else {
                TreeNode prevNode = curr.left;
                while (prevNode.right != null) {
                    prevNode = prevNode.right;
                }
                prevNode.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
        }

    }
}
