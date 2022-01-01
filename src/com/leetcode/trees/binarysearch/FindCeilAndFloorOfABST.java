package com.leetcode.trees.binarysearch;

import com.leetcode.trees.TreeNode;
import com.leetcode.trees.UtilityTree;


public class FindCeilAndFloorOfABST {

    public static void main(String[] args) {

        String tree = "8,3,10,1,6,null,14,null,null,5,7,13,null,null,null,null,null,null,null";
        int[] ceil = {-1};
        int key = 0;
        TreeNode root = UtilityTree.deserialize(tree);
        findCeil(root, key, ceil);
        System.out.printf("Ceil of %s : %s\n",key,ceil[0]);
        int[] floor = {-1};
        findFloor(root, key, floor);
        System.out.printf("Floor of %s : %s",key,floor[0]);


    }


    public static void findCeil(TreeNode root, int key, int[] ceil) {

        if (root == null) {
            return;
        }
        if (root.val >= key) {
            ceil[0] = root.val;
            findCeil(root.left, key, ceil);
        } else {
            findCeil(root.right, key, ceil);
        }
    }


    public static void findFloor(TreeNode root, int key, int[] floor) {

        if (root == null) {
            return;
        }
        if (root.val > key) {
            findFloor(root.left, key, floor);
        } else {
            floor[0] = root.val;
            findFloor(root.right, key, floor);
        }
    }
}
