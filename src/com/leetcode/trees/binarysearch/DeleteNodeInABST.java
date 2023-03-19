package com.leetcode.trees.binarysearch;

import com.leetcode.trees.TreeNode;
import com.leetcode.trees.UtilityTree;

public class DeleteNodeInABST {

    public static void main(String[] args) {

        String tree = "5,3,6,2,4,null,7";
        TreeNode root = UtilityTree.deserialize(tree);
        int key = 3;
        TreeNode treeNode = deleteNode(root, key);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {

        if(root.val<key){
            root.right=deleteNode(root.right,key);
        }else if(root.val>key){
            root.left=deleteNode(root.left,key);
        }else{
            //we found the node
            //leaf node
            if(root.left==null && root.right==null){
                return null;
            }else if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }else{
                //both the nodes contain value
                TreeNode nextNode=root.right;
                while(nextNode.left!=null){
                    nextNode=nextNode.left;
                }
                deleteNode(root,nextNode.val);
                root.val=nextNode.val;
                return root;
            }
        }
        return root;

    }

//    public static TreeNode deleteNode(TreeNode root, int key) {
//        if(root==null){
//            return null;
//        }
//
//        if(root.val > key){
//            root.left=deleteNode(root.left,key);
//        }else if(root.val < key){
//            root.right=deleteNode(root.right,key);
//        }else{
//            // when the values are equal, target is found
//
//            //leaf node
//            if(root.left==null && root.right==null){
//                return null;
//            }
//
//            //one child
//            else if(root.right==null || root.left==null){
//
//                if(root.right==null){
//                    root=root.left;
//                }else{
//                    root=root.right;
//                }
//            }
//
//            else{
//                //find the min On The Right SubTree
//                TreeNode currNode=findMinOnRight(root.right);
//                root.val=currNode.val;
//                root.right=deleteNode(root.right,currNode.val);
//            }
//
//            //two child
//        }
//        return root;
//    }
//
//    public static TreeNode findMinOnRight(TreeNode root){
//        while(root.left!=null){
//            root=root.left;
//        }
//        return root;
//    }

}
