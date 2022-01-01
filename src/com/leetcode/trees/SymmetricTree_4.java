package com.leetcode.trees;

import java.util.List;

/**
 * 101. Symmetric Tree
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * <p>
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 */
public class SymmetricTree_4 {

    private static TreeNode root;
    private static BinaryTree binaryTree = new BinaryTree();

    public static void main(String[] args) {
        createTree();
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }


    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val!=right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    private static void createTree() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
    }


}
