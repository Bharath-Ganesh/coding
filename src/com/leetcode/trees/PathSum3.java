package com.leetcode.trees;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 {


    public static void main(String[] args) {
        PathSum3 obj = new PathSum3();
        TreeNode node = obj.createNode();
        System.out.println(obj.pathSum(node, 8));
    }


    //3 5 2 4 7 6 N 2 4 5 2 6 6 N 7 4 1 4 4 1 N 1 7
    private TreeNode createNode() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);
        return root;
    }

    long count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Long> map = new HashMap<>();
        map.put(0l, 1l);
        pathSum(root, targetSum, 0, map);
        return (int) count;
    }

    public void pathSum(TreeNode root, int targetSum, long sum, Map<Long, Long> map) {

        if (root == null) return;

        sum += root.val;

        if (map.containsKey(sum - targetSum)) {
            count += map.get(sum - targetSum);
        }

        map.put(Long.valueOf(sum), Long.valueOf(map.getOrDefault(sum, 0l) + 1));

        pathSum(root.left, targetSum, sum, map);
        pathSum(root.right, targetSum, sum, map);
        map.put(Long.valueOf(sum), Long.valueOf(map.get(sum) - 1));

    }
}
