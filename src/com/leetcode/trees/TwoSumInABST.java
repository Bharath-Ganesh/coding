package com.leetcode.trees;

import java.util.Stack;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * 653. Two Sum IV - Input is a BST
 */
public class TwoSumInABST {



    public static void main(String[] args) {
        TwoSumInABST obj = new TwoSumInABST();
        TreeNode root = obj.createNode();
        System.out.println(obj.findTarget(root, 11));
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

    class BSTIterator {

        Stack<TreeNode> stack;
        boolean isReverse;

        public BSTIterator(TreeNode root,boolean isReverse) {
            stack=new Stack<>();
            this.isReverse=isReverse;
            pushAll(root);
        }

        private void pushAll(TreeNode root){
            if(isReverse){
                while(root!=null){
                    stack.push(root);
                    root=root.right;
                }
            }else{
                while(root!=null){
                    stack.push(root);
                    root=root.left;
                }
            }
        }

        public int next() {
            TreeNode currNode=stack.pop();
            if(isReverse){
                pushAll(currNode.left);
            }else{
                pushAll(currNode.right);
            }
            return currNode.val;
        }

    }



    public boolean findTarget(TreeNode root, int k) {
        BSTIterator front=new BSTIterator(root,false);
        BSTIterator reverse=new BSTIterator(root,true);

        int low=front.next();
        int high=reverse.next();

        while(low!=high){
            if(low+high==k){
                return true;
            }
            if(low+high > k){
                high=reverse.next();
            }else{
                low=front.next();
            }
        }
        return false;
    }
}
