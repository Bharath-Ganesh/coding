package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {

    public static void main(String[] args) {
        BinaryTreePath obj = new BinaryTreePath();
        TreeNode root = obj.createNode();
        System.out.println(obj.pathToGivenNode(root, 7));

    }

    //3 5 2 4 7 6 N 2 4 5 2 6 6 N 7 4 1 4 4 1 N 1 7
    private TreeNode createNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
//        root.left.left.left = new TreeNode(11);
//       root.left.left.right = new TreeNode(12);
        return root;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        binaryTreePaths(root, res, new ArrayList());
        return res;
    }

    public void binaryTreePaths(TreeNode root, List<String> res, List<String> currList) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            String path = "";
            for (String element : currList) {
                path += element + "->";
            }
            path += root.val;
            res.add(path);
            return;
        }

        currList.add(root.val + "");
        binaryTreePaths(root.left, res, currList);
        binaryTreePaths(root.right, res, currList);
        currList.remove(currList.size() - 1);
    }

    public ArrayList<Integer> pathToGivenNode(TreeNode A, int B) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        pathToGivenNode(A, B, res);
        return res;
    }

    public boolean pathToGivenNode(TreeNode root, int B, ArrayList<Integer> res) {
        if (root == null) return false;
        res.add(root.val);
        if (root.val == B) {
            return true;
        }
        if (pathToGivenNode(root.left, B, res) || pathToGivenNode(root.right, B, res)) {
            return true;
        }
        res.remove(res.size() - 1);
        return false;
    }
}
