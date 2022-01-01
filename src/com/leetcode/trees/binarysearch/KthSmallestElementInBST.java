package com.leetcode.trees.binarysearch;

import com.leetcode.trees.TreeNode;
import com.leetcode.trees.UtilityTree;

public class KthSmallestElementInBST {

    private static int count = 0;

    public static void main(String[] args) {
        String data = "5,2,6,null,3";
        TreeNode root = UtilityTree.deserialize(data);
        System.out.println(kthSmallest(root, 3));
    }

    private static int kthSmallest(TreeNode root, int k) {
        return kthsmallest(root, new int[]{k}).val;
    }

    static TreeNode kthsmallest(TreeNode root, int k[]) {
        if (root == null)
            return null;
        TreeNode left = kthsmallest(root.left, k);
        if (left != null)
            return left;
        k[0]--;
        if (k[0] == 0)
            return root;
        return kthsmallest(root.right, k);
    }

}
