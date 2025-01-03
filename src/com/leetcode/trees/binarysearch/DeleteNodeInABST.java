package com.leetcode.trees.binarysearch;

import com.leetcode.trees.TreeNode;
import com.leetcode.trees.UtilityTree;

public class DeleteNodeInABST {

    public static void main(String[] args) {

        String tree = "5,3,6,2,4,null,7";
        TreeNode root = UtilityTree.deserialize(tree);
        int key = 5;
        TreeNode treeNode = deleteNode(root, key);
        System.out.println(treeNode);
    }

    private static TreeNode findMinFromRightSubTree(TreeNode root){
        TreeNode min = root;
        while(root!=null){
            min = root;
            root = root.left;
        }
        return min;
    }

    public static TreeNode deleteNode(TreeNode root, int key) {

        if(root == null){
            return null;
        }

        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else{
            // Now the element is found
            // leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            // left child null
            else if(root.left == null){
                root = root.right;
            }
            // right child null
            else if( root.right == null){
                root = root.left;
            }
            // 2 child
            else {
                TreeNode minSubTree = findMinFromRightSubTree(root.right);
                root.val = minSubTree.val;
                root.right = deleteNode(root.right, minSubTree.val);
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
