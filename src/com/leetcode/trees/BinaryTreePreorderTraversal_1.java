package com.leetcode.trees;

import java.util.*;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 */
public class BinaryTreePreorderTraversal_1 {

    private static TreeNode root;
    private static BinaryTree binaryTree = new BinaryTree();

    public static void main(String[] args) {
        createTree();
        List<Integer> preorderTraversal=preorderTraversal(root);
        preorderTraversal.forEach(System.out::println);
    }


    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currTree = stack.pop();
            list.add(currTree.val);
            if (currTree.right != null)
                stack.push(currTree.right);
            if (currTree.left != null)
                stack.push(currTree.left);
        }
        return list;

    }

    private static void createTree() {
        add(1);
        add(4);
        add(12);
        add(21);
        add(5);
    }

    public static void add(Integer value) {
        root = binaryTree.createBinarySearchTree(root, value);
    }




}
