package com.leetcode.trees;

/**
 * https://www.geeksforgeeks.org/print-path-root-given-node-binary-tree/
 */
public class PathToGivenNode {

    public static void main(String[] args) {
        PathToGivenNode obj = new PathToGivenNode();
        TreeNode node = obj.createNode();
        String path = "";
        obj.pathToGivenNode(node, 7, path);
        System.out.println(path);

    }

    private TreeNode createNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    public boolean pathToGivenNode(TreeNode root, int val, String path) {

        if (root == null) return false;

        if (root.val == val) {
            path += root.val;
            System.out.println(path);
            return true;
        }

        path += root.val + "->";
        if (pathToGivenNode(root.left, val, path) || pathToGivenNode(root.right, val, path)) {
            return true;
        }
        return false;
    }
}
