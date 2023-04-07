package com.leetcode.trees;

/**
 * https://practice.geeksforgeeks.org/problems/children-sum-parent/1
 */
public class ChildSumProperty {

    public static void main(String[] args) {
        ChildSumProperty obj=new ChildSumProperty();
        Node node=obj.constructNode();
        int sumProperty = obj.isSumProperty(node);
        System.out.println(sumProperty);
    }

    private  Node constructNode() {
        //4 4 N 4 N N N
        Node root=new Node(4);
        root.left=new Node(4);
        root.left.left=new Node(4);
        return root;
    }


    public int isSumProperty(Node root)
    {
        // add your code here
        int val=findChildSum(root);
        return val==-1?0:1;
    }

    public int findChildSum(Node root)
    {
        // add your code here
        if(root==null) return 0;

        if(root.left==null && root.right==null) return root.data;

        int left=findChildSum(root.left);
        int right=findChildSum(root.right);

        if(left+right!=root.data){
            return -1;
        }

        if(left==-1 || right==-1){
            return -1;
        }

        return root.data;
    }
}
