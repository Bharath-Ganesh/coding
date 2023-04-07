package com.leetcode.trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructABinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        ConstructABinaryTreeFromPreorderAndInorderTraversal obj = new ConstructABinaryTreeFromPreorderAndInorderTraversal();
        int[] inorder= {9,6,8,-5,-3,1,4,10,2};
        int[] preorder={2,8,6,9,1,-5,-3,4,10};
        obj.buildTree(preorder, inorder);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=inorder.length;

        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }

        int pStart=0,iStart=0;
        int pEnd=n-1,iEnd=n-1;

        return buildTree(preorder,pStart,pEnd,inorder,iStart,iEnd,map);
    }

    public static TreeNode buildTree(int[] preorder,int pStart,int pEnd,int[] inorder,int iStart,int iEnd,Map<Integer,Integer> map) {

        if(pStart>pEnd || iStart>iEnd){
            return null;
        }

        TreeNode root=new TreeNode(preorder[pStart]);
        int index=map.get(preorder[pStart]);
        int numsToLeft=index-iStart;

        root.left=buildTree(preorder,pStart+1,pStart+numsToLeft,inorder,iStart,index-1,map);
        root.right=buildTree(preorder,pStart+numsToLeft+1,pEnd,inorder,index+1,iEnd,map);
        return root;
    }
}
