package com.leetcode.trees;

import java.util.*;


class Tuples {
    TreeNode node;
    int row;
    int col;

    Tuples(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

public class VerticalOrderTraversal {

    public static void main(String[] args) {
        VerticalOrderTraversal obj = new VerticalOrderTraversal();
        TreeNode root = obj.createNode();
        System.out.println(obj.verticalTraversal(root));
    }

    private TreeNode createNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    class Pair{
        TreeNode root;
        int col;
        int row;

        public Pair(TreeNode root,int col,int row){
            this.root=root;
            this.col=col;
            this.row=row;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Pair p=new Pair(root,0,0);
        Queue<Pair> queue=new LinkedList<>();
        queue.add(p);
        while(!queue.isEmpty()){
            Pair treeNode=queue.remove();
            TreeNode node=treeNode.root;
            int row=treeNode.row;
            int col=treeNode.col;

            if(!map.containsKey(col)){
                map.put(col,new TreeMap());
            }

            if(!map.get(col).containsKey(row)){
                map.get(col).put(row,new PriorityQueue<>());
            }

            PriorityQueue<Integer> pq=map.get(col).get(row);
            pq.add(node.val);

            if(node.right!=null){
                queue.add(new Pair(node.right,col+1,row+1));
            }
            if(node.left!=null){
                queue.add(new Pair(node.left,col-1,row+1));
            }
        }


        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> colSet : map.entrySet()) {
            List<Integer> temp=new ArrayList<>();
            for (Map.Entry<Integer, PriorityQueue<Integer>> rowSet : colSet.getValue().entrySet()) {
                PriorityQueue<Integer> value = rowSet.getValue();
                while (!value.isEmpty()){
                    temp.add(value.remove());
                }
            }
            res.add(temp);
        }
        return res;
    }
}
