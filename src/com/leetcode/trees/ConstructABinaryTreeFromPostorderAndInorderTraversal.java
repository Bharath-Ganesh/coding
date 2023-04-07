package com.leetcode.trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructABinaryTreeFromPostorderAndInorderTraversal {

    public static void main(String[] args) {
        ConstructABinaryTreeFromPostorderAndInorderTraversal obj = new ConstructABinaryTreeFromPostorderAndInorderTraversal();
        int[] postorder = {5,6,9,15,7,20,3};
        int[] inorder = {5,9,6,3,15,20,7};
        obj.buildTree(postorder, inorder);
    }

    public TreeNode buildTree(int[] postorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int size = postorder.length;
        TreeNode root = buildTree(postorder, 0, size - 1, inorder, 0, size - 1, map);
        return root;
    }

    public TreeNode buildTree(int[] postorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer, Integer> map) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pEnd]);
        int index = map.get(postorder[pEnd]);
        int numsToLeft = index - iStart;
        root.left = buildTree(postorder, pStart, pStart + numsToLeft-1, inorder, iStart, index - 1, map);
        root.right = buildTree(postorder, index + 1, pEnd - 1, inorder, index + 1, iEnd, map);
        return root;
    }
}
