package com.leetcode.trees;

public class Trial {

    public static void main(String[] args) {
        int[] inorder = {9, 6, 8, -5, -3, 1, 4, 10, 2};
        int[] preorder = {2, 8, 6, 9, 1, -5, -3, 4, 10};
        TreeNode treeNode = ConstructABinaryTreeFromPreorderAndInorderTraversal.buildTree(preorder, inorder);
        int sum = new Trial().maxSumBST(treeNode);
        System.out.println(sum);
    }

    class NodeValue {

        int sum;
        int max;
        int min;

        public NodeValue(int sum, int max, int min) {
            this.sum = sum;
            this.max = max;
            this.min = min;
        }
    }

    private int maxSum = 0;

    // Return the size of the largest sub-tree which is also a BST
    public int maxSumBST(TreeNode root) {
        postOrderTraverse(root);
        return maxSum;
    }

    private int[] postOrderTraverse(TreeNode root) {
        if (root == null)
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}; // {min, max, sum}, initialize min=MAX_VALUE, max=MIN_VALUE
        int[] left = postOrderTraverse(root.left);
        int[] right = postOrderTraverse(root.right);
        // The BST is the tree:
        if (!(left != null             // the left subtree must be BST
                && right != null            // the right subtree must be BST
                && root.val > left[1]       // the root's key must greater than maximum keys of the left subtree
                && root.val < right[0]))    // the root's key must lower than minimum keys of the right subtree
            return null;
        int sum = root.val + left[2] + right[2]; // now it's a BST make `root` as root
        maxSum = Math.max(maxSum, sum);
        int min = Math.min(root.val, left[0]);
        int max = Math.max(root.val, right[1]);
        return new int[]{min, max, sum};
    }

}
