package com.leetcode.trees;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 * 450. Delete Node in a BST
 */
public class DeleteNodeInBST {

    public static void main(String[] args) {
        DeleteNodeInBST obj = new DeleteNodeInBST();
        TreeNode root = obj.createNode();
        obj.deleteNode(root, 3);
    }

    private TreeNode createNode() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        //
        if (root == null) return null;

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            //case 1 : leaf node
            if (root.left == null && root.right == null) {
                root = null;
            }
            // case 2: only one child
            else if (root.left == null || root.right == null) {
                root = root.left == null ? root.right : root.left;
            }
            //case 3 : Both child exist
            else {
                //find min of the right subtree or maximum of the left subtree
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
