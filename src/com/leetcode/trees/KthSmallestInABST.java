package com.leetcode.trees;

public class KthSmallestInABST {

    public static void main(String[] args) {
        KthSmallestInABST obj = new KthSmallestInABST();
        TreeNode root = obj.createNode();
        System.out.println(obj.kthSmallest(root, 5));
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

    public int kthSmallest(TreeNode root, int k) {
        int val = solve(root, new int[]{k});
        return val == Integer.MIN_VALUE ? -1 : val;
    }

    public int solve(TreeNode root, int k[]) {
        if (root == null) return Integer.MIN_VALUE;

        int left = solve(root.left, k);
        if (left != Integer.MIN_VALUE)
            return left;
        k[0]--;
        if (k[0] == 0)
            return root.val;
        int right = solve(root.right, k);
        return right;
    }
}
