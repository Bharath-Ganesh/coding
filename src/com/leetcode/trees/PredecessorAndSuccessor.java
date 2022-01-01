package com.leetcode.trees;

class Res {

    TreeNode pre;
    TreeNode succ;

    public Res() {
        this.pre = null;
        this.succ = null;
    }
}

public class PredecessorAndSuccessor {

    public static void main(String[] args) {
        PredecessorAndSuccessor obj = new PredecessorAndSuccessor();
        TreeNode root = obj.createNode();
        Res p = new Res();
        Res s = new Res();
        findPreSucRecursive(root, p, s, 10);
    }

    private TreeNode createNode() {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(12);
        return root;
    }


    public static void findPreSucRecursive(TreeNode root, Res p, Res s, int key) {
        // add your code here
        if (root == null) return;
        findPreSucRecursive(root.left, p, s, key);
        if (root.val < key) {
            p.pre = root;
        } else if (root.val > key && s.succ == null) {
            s.succ = root;
        }
        findPreSucRecursive(root.right, p, s, key);
    }

    public static void findPreSuc(TreeNode root, Res p, Res s, int key) {
        // add your code here

        if (root == null) return;

        TreeNode suc = null;
        TreeNode pre = null;
        while (root != null && root.val != key) {
            if (root.val > key) {
                suc = root;
                root = root.left;
            } else {
                pre = root;
                root = root.right;
            }
        }

        findMax(root.left, pre, p);
        findMin(root.right, suc, s);
    }

    private static void findMax(TreeNode root, TreeNode pre, Res p) {
        if (root == null || root.left == null) {
            p.pre = pre;
            return;
        }
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        p.pre = root;
    }

    private static void findMin(TreeNode root, TreeNode suc, Res s) {
        if (root == null || root.right == null) {
            s.succ = suc;
            return;
        }
        root = root.right;
        while (root != null && root.left != null) {
            root = root.left;
        }
        s.succ = root;
    }


}
