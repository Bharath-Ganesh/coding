package com.leetcode.trees;

import com.leetcode.linkedlist.HappyNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MaximumSumBST {

    public static void main(String[] args) {
        MaximumSumBST obj = new MaximumSumBST();
        TreeNode node = obj.createNode();
        int sum = obj.maxSumBST(node);
        System.out.println(sum);
        
    }

    private TreeNode createNode() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(6);
        root.left.left.left = new TreeNode(9);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(-5);
        root.left.right.right = new TreeNode(4);
        root.left.right.left.right = new TreeNode(-3);
        root.left.right.right.right = new TreeNode(10);
        return root;
    }

    class NodeValue {

        int max;
        int min;
        int sum;

        public NodeValue(int min, int max, int sum) {
            this.max = max;
            this.min = min;
            this.sum = sum;
        }
    }

    public int maxSumBST(TreeNode root) {
        int sum = maxSum(root).sum;
        return sum > 0 ? sum : 0;
    }

    public NodeValue maxSum(TreeNode root) {
        // Write your code here

        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = maxSum(root.left);
        NodeValue right = maxSum(root.right);

        if (left.max < root.val && root.val < right.min) {

            return new NodeValue(Math.min(left.min, root.val), Math.max(root.val, right.max), Math.max(0, left.sum) + Math.max(0, right.sum) + root.val);
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.sum, right.sum));
    }
}
