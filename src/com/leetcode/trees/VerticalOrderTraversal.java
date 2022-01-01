package com.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;


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

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // TreeMap is required because we want to print it in ascending order of col
        // Priority Queue is used because we want to print the element of same level in ascending order of values
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuples> queue = new LinkedList();
        Tuples tup = new Tuples(root, 0, 0);
        queue.add(tup);
        while (!queue.isEmpty()) {
            //pop the first element
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Tuples curr = queue.remove();
                TreeNode currNode = curr.node;
                int row = curr.row;
                int col = curr.col;
                //logic to check whether it contains in the tree map

                if (!map.containsKey(col)) {
                    TreeMap<Integer, PriorityQueue<Integer>> temp = new TreeMap<>();
                    map.put(col, temp);
                }

                if (!map.get(col).containsKey(row)) {
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    map.get(col).put(row, pq);
                }

                PriorityQueue<Integer> pq = map.get(col).get(row);
                pq.add(currNode.val);
                map.get(col).put(row, pq);
                if (currNode.left != null) {
                    queue.add(new Tuples(currNode.left, row + 1, col - 1));
                }
                if (currNode.right != null) {
                    queue.add(new Tuples(currNode.right, row + 1, col + 1));
                }
            }
        }

//        for (Integer col : map.keySet()) {
//            List<Integer> currList = new ArrayList<>();
//            for (Integer row : map.get(col).keySet()) {
//                currList.addAll(map.get(col).get(row));
//            }
//            res.add(new ArrayList<>(currList));
//        }


        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            res.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    res.get(res.size() - 1).add(nodes.poll());
                }
            }
        }

        //Iterate the TreeMap


        return res;
    }
}
