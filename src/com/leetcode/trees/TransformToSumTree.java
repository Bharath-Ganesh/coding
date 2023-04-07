package com.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TransformToSumTree {


    public static void main(String[] args) {
        TransformToSumTree ser = new TransformToSumTree();
        String data="1 N 7 6 10 2 N 9 N N 3 8 N N 5 N N 4 N";
        TreeNode root = ser.createNode();
        TreeNode deserialize = ser.deserialize(ser.serialize(root));
        System.out.println(ser.sumOfLongRootToLeafPath(root));
        System.out.println();
    }

    private TreeNode createNode() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        root.right.left.left = new TreeNode(2);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(8);

        root.right.left.left.right = new TreeNode(3);
        root.right.left.left.right.right = new TreeNode(5);
        root.right.left.left.right.right.left = new TreeNode(4);

        return root;
    }

    public  String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder answer=new StringBuilder();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.remove();
            if(node==null){
                answer.append("n,");
                continue;
            }
            answer.append(node.val+ ",");
            queue.add(node.left);
            queue.add(node.right);
        }
        return answer.toString();
    }

    // Decodes your encoded data to tree.
    public  TreeNode deserialize(String data) {
        if(data=="") return null;

        String[] nodes=data.split(",");
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);
        for(int i=1;i<nodes.length;i++){
            TreeNode currNode=queue.remove();
            if(!nodes[i].equals("n")){
                TreeNode newNode=new TreeNode(Integer.parseInt(nodes[i]));
                currNode.left=newNode;
                queue.add(newNode);
            }

            if(!nodes[++i].equals("n")){
                TreeNode newNode=new TreeNode(Integer.parseInt(nodes[i]));
                currNode.right=newNode;
                queue.add(newNode);
            }
        }
        return root;
    }


//    public String serialize(TreeNode root) {
//        StringBuilder serialization = new StringBuilder();
//        if (root == null) {
//            return serialization.toString();
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            TreeNode currNode = queue.remove();
//            if (currNode == null) {
//                serialization.append("N");
//                serialization.append(" ");
//                continue;
//            }
//            serialization.append(currNode.data);
//            queue.add(currNode.left);
//            queue.add(currNode.right);
//            serialization.append(" ");
//        }
//        return serialization.toString();
//    }
//
//    public TreeNode deserialize(String data) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        if (data.isEmpty()) {
//            return null;
//        }
//        String[] split = data.split(" ");
//        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
//        queue.add(root);
//        int index = 0;
//        while (!queue.isEmpty()) {
//            TreeNode currNode = queue.remove();
//            if (!(split[++index]).equals("N")) {
//                TreeNode left = new TreeNode(Integer.parseInt(split[index]));
//                currNode.left = left;
//                queue.add(left);
//            }
//
//            if (!(split[++index]).equals("N")) {
//                TreeNode right = new TreeNode(Integer.parseInt(split[index]));
//                currNode.right = right;
//                queue.add(right);
//            }
//        }
//        return root;
//    }



    public int sumOfLongRootToLeafPath(TreeNode root)
    {
        //code here
        if(root==null){
            return 0;
        }

        if(root.left==null && root.right==null){
            return root.val;
        }

        int left=sumOfLongRootToLeafPath(root.left);
        int right=sumOfLongRootToLeafPath(root.right);
        return Math.max(left,right)+root.val;
    }
}
