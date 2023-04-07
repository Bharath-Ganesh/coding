package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllInOneTraversal {

    class Pair{
        int num;
        TreeNode tree;
        Pair(TreeNode root,int val){
            this.num=val;
            this.tree=root;
        }
    }


    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> postOrder=new ArrayList<>();
        List<Integer> preOrder=new ArrayList<>();
        List<Integer> inOrder=new ArrayList<>();
        if(root==null){
            return postOrder;
        }
        Stack<Pair> stack=new Stack<>();
        Pair pair=new Pair(root,1);
        stack.push(pair);
        while(!stack.isEmpty()){
            Pair p=stack.pop();
            if(p.num==1){
                preOrder.add(p.tree.val);
                p.num++;
                stack.push(p);
                if(p.tree.left!=null){
                    stack.push(new Pair(p.tree.left,1));
                }
            }else if(p.num==2){
                inOrder.add(p.tree.val);
                p.num++;
                stack.push(p);
                if(p.tree.right!=null){
                    stack.push(new Pair(p.tree.right,1));
                }
            }else{
                postOrder.add(p.tree.val);
            }
        }
        return preOrder;
    }
}
