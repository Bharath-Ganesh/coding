package com.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree ser = new SerializeAndDeserializeBinaryTree();
        TreeNode root = ser.createNode();
        SerializeAndDeserializeBinaryTree des = new SerializeAndDeserializeBinaryTree();
        TreeNode desRoot = des.deserialize(ser.serialize(root));
    }

    private TreeNode createNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        return root;
    }

    public String serialize(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        StringBuilder serializedString=new StringBuilder();
        while(!queue.isEmpty()){
            TreeNode node=queue.remove();
            if(node==null){
                serializedString.append("n,");
                continue;
            }
            serializedString.append(node.val+",");
            queue.add(node.left);
            queue.add(node.right);
        }
        return serializedString.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        for(int i=0;i<nodes.length-1;){
            TreeNode node=queue.remove();
            TreeNode leftNode=null;
            TreeNode rightNode=null;
            if(!(nodes[++i].equals("n")) ){
                leftNode=new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(leftNode);
            }

            if(!(nodes[++i].equals("n"))){
                rightNode=new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(rightNode);
            }
            node.left=leftNode;
            node.right=rightNode;
        }
        return root;
    }



    // Encodes a tree to a single string.
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
//            serialization.append(currNode.val);
//            queue.add(currNode.left);
//            queue.add(currNode.right);
//            serialization.append(" ");
//        }
//        return serialization.toString();
//    }
//
//    // Decodes your encoded data to tree.
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
}
