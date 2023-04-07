package com.leetcode.trees;

public class RecoverTree {
    public static void main(String[] args) {
        RecoverTree obj = new RecoverTree();
        TreeNode node = obj.createNode();
        obj.recoverTree(node);

    }

    private TreeNode createNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        return root;
    }

    TreeNode prev = null;
    TreeNode first = null;
    TreeNode middle = null;
    TreeNode last = null;

    public void recoverTree(TreeNode root) {
        recoverSwappedTree(root);
        if (last != null) {
            swap(first, last);
        } else {
            swap(first, middle);
        }
    }

    public void swap(TreeNode first, TreeNode second) {
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void recoverSwappedTree(TreeNode root) {
        if (root == null) return;

        recoverSwappedTree(root.left);
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        recoverSwappedTree(root.right);
        prev = root;

    }
}
