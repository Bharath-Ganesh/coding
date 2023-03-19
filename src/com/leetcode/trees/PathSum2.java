package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    public static void main(String[] args) {
        PathSum2 obj = new PathSum2();
        TreeNode node = obj.createNode();
        System.out.println(obj.pathSum(node, 22));
    }


    //3 5 2 4 7 6 N 2 4 5 2 6 6 N 7 4 1 4 4 1 N 1 7
    private TreeNode createNode() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        return root;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        pathSum(root, targetSum, res, curr);
        return res;
    }

//    public void pathSum(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> curr) {
//
//        if (root == null) {
//            return;
//        }
//        curr.add(root.val);
//        if (root.val == targetSum && root.left == null && root.right == null) {
//            res.add(new ArrayList<>(curr));
//            return;
//        }
//        pathSum(root.left, targetSum - root.val, res, new ArrayList<>(curr));
//        pathSum(root.right, targetSum - root.val, res, new ArrayList<>(curr));
//    }

    public void pathSum(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> curr) {

        if (root == null) {
            return;
        }
        targetSum -= root.val;
        curr.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                res.add(new ArrayList<>(curr));
            }
        } else {
            pathSum(root.left, targetSum, res, curr);
            pathSum(root.right, targetSum, res, curr);
        }
        curr.remove(curr.size() - 1);

    }
}
