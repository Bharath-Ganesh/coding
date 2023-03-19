package com.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.trees.TreeNode;


public class UtilityTree {


    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (data.isEmpty()) {
            return null;
        }
        String[] split = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.add(root);
        int index = 0;
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.remove();

            if (index == split.length - 1)
                break;
            if (!(split[++index]).equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(split[index]));
                currNode.left = left;
                queue.add(left);
            }

            if (index == split.length - 1)
                break;

            if (!(split[++index]).equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(split[index]));
                currNode.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}

