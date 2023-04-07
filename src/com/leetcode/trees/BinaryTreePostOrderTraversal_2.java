package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 */
public class BinaryTreePostOrderTraversal_2 {

    private static TreeNode root;
    private static BinaryTree binaryTree = new BinaryTree();

    public static void main(String[] args) {
        createTree();
        List<Integer> preorderTraversal = postorderTraversal(root);
        preorderTraversal.forEach(x -> System.out.printf("%d ", x));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode curr = stack1.pop();
            stack2.push(curr);
            if (curr.left != null)
                stack1.push(curr.left);
            if (curr.right != null)
                stack1.push(curr.right);
        }
        List<Integer> postOrder = new ArrayList<>();
        while (!stack2.isEmpty()) {
            postOrder.add(stack2.pop().val);
        }
        return postOrder;
    }

    public static List<Integer> postorderTraversalUsingOneStack(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> postorder = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.peek();
                    postorder.add(stack.pop().val);
                    while (!stack.isEmpty() && stack.peek().right == temp) {
                        temp = stack.peek();
                        stack.pop();
                        postorder.add(temp.val);
                    }
                } else {
                    curr = temp;
                }
            }
        }
        return postorder;
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
