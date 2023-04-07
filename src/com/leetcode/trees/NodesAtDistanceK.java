package com.leetcode.trees;

import java.util.*;

/**
 * Given the root of a binary tree, the value of a target node target, and an integer k,
 * return an array of the values of all nodes that have a distance k from the target node.
 * <p>
 * You can return the answer in any order.
 */
public class NodesAtDistanceK {

    public static void main(String[] args) {
        NodesAtDistanceK obj = new NodesAtDistanceK();
        TreeNode root = obj.createNode();
      //  System.out.println(obj.inorderTraversal(root));
        TreeNode target = root.left;
        System.out.println(obj.distanceK(root, target, 2));
    }

    private TreeNode createNode() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        return root;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res=new ArrayList<>();
        Map<TreeNode,TreeNode> map=new HashMap<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr=queue.remove();
            if(curr.left!=null){
                queue.add(curr.left);
                map.put(curr.left,curr);
            }
            if(curr.right!=null){
                queue.add(curr.right);
                map.put(curr.right,curr);
            }
        }


        int count=0;
        queue=new LinkedList<>();
        queue.add(target);
        Set<TreeNode> visited=new HashSet<>();
        visited.add(target);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode currNode=queue.remove();

                //left
                if(currNode.left!=null && visited.add(currNode.left)){
                    queue.add(currNode.left);
                }


                //right
                if(currNode.right!=null && visited.add(currNode.right)){
                    queue.add(currNode.right);
                }

                //upwards
                if(map.containsKey(currNode) && visited.add(map.get(currNode))){
                    queue.add(map.get(currNode));
                }
            }
            count++;
            if(count==k){
                break;
            }
        }

        while(!queue.isEmpty()){
            res.add(queue.remove().val);
        }
        return res;
    }

//    public List<Integer> distanceK(TreeNode root, int num, int k) {
//        Map<TreeNode, TreeNode> map = new HashMap<>();
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode currNode = queue.remove();
//                if (currNode.left != null) {
//                    map.put(currNode.left, currNode);
//                    queue.add(currNode.left);
//                }
//                if (currNode.right != null) {
//                    map.put(currNode.right, currNode);
//                    queue.add(currNode.right);
//                }
//            }
//        }
//
//        int count = 0;
//        TreeNode target = findNode(root, num);
//        queue.add(target);
//        Map<TreeNode, Boolean> visited = new HashMap<>();
//        visited.put(target, true);
//        while (count != k && !queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode currNode = queue.remove();
//                if (currNode.left != null && !visited.containsKey(currNode.left)) {
//                    visited.put(currNode.left, true);
//                    queue.add(currNode.left);
//                }
//
//                if (currNode.right != null && !visited.containsKey(currNode.right)) {
//                    visited.put(currNode.right, true);
//                    queue.add(currNode.right);
//                }
//                TreeNode parent = map.getOrDefault(currNode, null);
//                if (parent != null && !visited.containsKey(parent)) {
//                    visited.put(parent, true);
//                    queue.add(parent);
//                }
//            }
//            count++;
//            //move radially in left,right and upward directions
//        }
//        while (!queue.isEmpty()) {
//            res.add(queue.remove().val);
//        }
//        return res;
//    }
//
//    private TreeNode findNode(TreeNode root, int num) {
//        if (root == null) {
//            return null;
//        }
//
//        if (root.val == num) {
//            return root;
//        }
//
//        TreeNode left = findNode(root.left, num);
//        TreeNode right = findNode(root.right, num);
//
//        if (left == null) {
//            return right;
//        } else if (right == null) {
//            return left;
//        } else {
//            return root;
//        }
//
//    }
//
//    public List<Integer> inorderTraversal(TreeNode root) {
//
//
//        List<Integer> inorder = new ArrayList<>();
//        if (root == null) {
//            return inorder;
//        }
//        Stack<TreeNode> treeStack = new Stack<>();
//        TreeNode curr = root;
//        while (!treeStack.isEmpty() || curr != null) {
//            if (curr != null) {
//                treeStack.push(curr);
//                curr = curr.left;
//            } else {
//                curr = treeStack.pop();
//                inorder.add(curr.val);
//                curr = curr.right;
//            }
//        }
//        return inorder;
//
//    }

}
