package com.leetcode.trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructABinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        ConstructABinaryTreeFromPreorderAndInorderTraversal obj = new ConstructABinaryTreeFromPreorderAndInorderTraversal();
        int[] preorder = {9, 3, 15, 20, 7};
        int[] inorder = {3, 9, 20, 15, 7};
        obj.buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        int size = preorder.length;
        TreeNode root = buildTree(preorder, 0, size - 1, inorder, 0, size - 1, map);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer, Integer> map) {

        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        int index = map.get(preorder[pStart]);
        int numsToLeft = index - iStart;
        root.left = buildTree(preorder, pStart + 1, pStart + numsToLeft, inorder, iStart, index - 1, map);
        root.right = buildTree(preorder, pStart + numsToLeft + 1, pEnd, inorder, index + 1, iEnd, map);
        return root;
    }
}
