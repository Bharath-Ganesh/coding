package com.leetcode.trees;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        LowestCommonAncestor obj = new LowestCommonAncestor();
        TreeNode root = obj.createNode();
        TreeNode p = root.left;
        TreeNode q = root.left.right.right;
        System.out.println(obj.lowestCommonAncestor(root, p, q).val);

    }



    //3 5 2 4 7 6 N 2 4 5 2 6 6 N 7 4 1 4 4 1 N 1 7
    private TreeNode createNode() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        //right tree
//        root.right.left = new TreeNode(0);
//        root.right.right = new TreeNode(8);
        return root;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}
