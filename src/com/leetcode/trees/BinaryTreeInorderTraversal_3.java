package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class BinaryTreeInorderTraversal_3 {

    private static TreeNode root;
    private static BinaryTree binaryTree = new BinaryTree();

    public static void main(String[] args) {
        createTree();
        List<Integer> preorderTraversal = inorderTraversal(root);
        preorderTraversal.forEach(x-> System.out.printf("%d ",x));
    }



    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> inorder=new ArrayList<>();
        if(root==null){
            return inorder;
        }
        Stack<TreeNode> treeStack=new Stack<>();

        TreeNode curr=root;
        while(!treeStack.isEmpty() || curr!=null){
            if(curr!=null){
                treeStack.push(curr);
                curr=curr.left;
            }else{
                curr=treeStack.pop();
                inorder.add(curr.val);
                curr=curr.right;
            }
        }
        return  inorder;

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
