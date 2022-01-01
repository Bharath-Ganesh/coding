package com.leetcode.trees;

/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBST {
    public static void main(String[] args) {
        ValidateBST obj=new ValidateBST();
        TreeNode root=obj.createNode();
        System.out.println(obj.isValidBST(root));
    }

    private TreeNode createNode() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        return root;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root,long min,long max){
        if(root==null){
            return true;
        }

        if(root.val <= min || root.val>=max){
            return false;
        }

        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
    }
}
