package com.leetcode.trees;

import java.util.*;

public class NodesDistanceKInBinaryTree {

    public static void main(String[] args) {
        NodesDistanceKInBinaryTree obj = new NodesDistanceKInBinaryTree();
        TreeNode root = obj.createNode();
        System.out.println(obj.distanceK(root, root.left, 2));
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
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        constructParent(root, parentMap);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        while (!queue.isEmpty() && k > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.remove();

                if (currNode.left != null && visited.add(currNode.left)) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null && visited.add(currNode.right)) {
                    queue.add(currNode.right);
                }

                if (parentMap.containsKey(currNode) && visited.add(parentMap.get(currNode))) {
                    queue.add(parentMap.get(currNode));
                }
            }
            k--;
        }
        while (!queue.isEmpty()) {
            res.add(queue.remove().val);
        }
        return res;
    }

    public void constructParent(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        if (root == null) return;

        if (root.left == null && root.right == null) return;

        if (root.left != null && !parentMap.containsKey(root.left)) {
            parentMap.put(root.left, root);
        }

        if (root.right != null && !parentMap.containsKey(root.right)) {
            parentMap.put(root.right, root);
        }
        constructParent(root.left, parentMap);
        constructParent(root.right, parentMap);
    }

//    public Map<TreeNode, TreeNode> constructParent(TreeNode root) {
//        Map<TreeNode, TreeNode> map = new HashMap<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode curNode = queue.remove();
//                if (curNode.left != null) {
//                    map.put(curNode.left, curNode);
//                    queue.add(curNode.left);
//                }
//                if (curNode.right != null) {
//                    map.put(curNode.right, curNode);
//                    queue.add(curNode.right);
//                }
//            }
//        }
//        return map;
//    }
//
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        Map<TreeNode, TreeNode> map = constructParent(root);
//        Set<TreeNode> visited = new HashSet<>();
//        visited.add(target);
//        int curDist = 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(target);
//        while (true) {
//            if (curDist == k) {
//                break;
//            }
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode currNode = queue.remove();
//                if (currNode.left != null && !visited.contains(currNode.left)) {
//                    visited.add(currNode.left);
//                    queue.add(currNode.left);
//                }
//
//                if (currNode.right != null && !visited.contains(currNode.right)) {
//                    visited.add(currNode.right);
//                    queue.add(currNode.right);
//                }
//
//                if (map.get(currNode) != null && !visited.contains(map.get(currNode))) {
//                    visited.add(map.get(currNode));
//                    queue.add(map.get(currNode));
//                }
//            }
//            curDist += 1;
//        }
//        while (!queue.isEmpty()) {
//            res.add(queue.remove().val);
//        }
//        return res;
//    }
}
