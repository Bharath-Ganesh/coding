package com.leetcode.trees.binarysearch;

import com.leetcode.trees.TreeNode;
import com.leetcode.trees.UtilityTree;

import java.util.Stack;

class BSTIterator {

    public Stack<TreeNode> stack = new Stack<>();
    public Boolean reverse;

    public BSTIterator(TreeNode root, Boolean isReverse) {
        this.reverse = isReverse;
        pushAll(root);
    }

    public int next() {
        if (hasNext()) {
            TreeNode curr = stack.pop();
            if (!reverse) {
                pushAll(curr.right);
            } else {
                pushAll(curr.left);
            }
            return curr.val;
        }
        return -1;
    }

    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public void pushAll(TreeNode root) {
        while (root != null) {
            stack.push(root);
            if (reverse) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }
}


public class TwoSumBST {

    public static void main(String[] args) {
        TwoSumBST obj = new TwoSumBST();
        String data = "2,1,3";
        TreeNode root = UtilityTree.deserialize(data);
        System.out.println(obj.findTarget(root, 1));
    }

    public boolean findTarget(TreeNode root, int k) {
        BSTIterator start = new BSTIterator(root, false);
        BSTIterator end = new BSTIterator(root, true);

        while (start.hasNext()) {
            System.out.printf(start.next() + " ");
        }

        System.out.println("\n");
        while (end.hasNext()) {
            System.out.printf(end.next() + " ");
        }

        int low = start.next();
        int high = end.next();
        while (low != high) {
            if (low + high == k) {
                return true;
            } else if (low + high < k) {
                low = start.next();
            } else {
                high = end.next();
            }
        }
        return false;
    }
}
