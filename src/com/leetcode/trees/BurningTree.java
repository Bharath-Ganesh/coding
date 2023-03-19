package com.leetcode.trees;

import java.util.*;

public class BurningTree {

    static final String CONTACT_INFO_CUSTOM_FIELDS_TEXT_FIELDS = "text_field";

    public static void main(String[] args) {
        BurningTree obj = new BurningTree();
//        Node root = obj.createNode();
//        System.out.println(obj.inorderTraversal(root));
//        int target = 8;
//        System.out.println(obj.minTime(root, target));
        obj.textMethod();
    }

    private void textMethod() {
        System.out.println(CONTACT_INFO_CUSTOM_FIELDS_TEXT_FIELDS);
    }

    private Node createNode() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);
        root.right.right.right = new Node(9);
        root.right.right.right.right = new Node(10);


        root.left.right.right = new Node(8);
        root.left.right.left = new Node(7);
        return root;
    }

    private static Node findNode(Node root, int num) {
        if (root == null) {
            return null;
        }

        if (root.data == num) {
            return root;
        }

        Node left = findNode(root.left, num);
        Node right = findNode(root.right, num);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }

    }

    private static Node findTargetNode(Node root, int num) {

        if (root == null) {
            return root;
        }

        if (root.data == num) {
            return root;
        }

        Node left = findTargetNode(root.left, num);
        Node right = findTargetNode(root.right, num);
        if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
    }


    private static Map<Node, Node> findParentNode(Node root) {
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currNode = queue.remove();
                if (currNode.left != null) {
                    map.put(currNode.left, currNode);
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    map.put(currNode.right, currNode);
                    queue.add(currNode.right);
                }
            }
        }
        return map;
    }

    public static int minTime(Node root, int target) {
        // Your code goes here
        int minTime = 0;
        Node tarNode = findTargetNode(root, target);
        if (tarNode == null) {
            return minTime;
        }
        Map<Node, Node> map = findParentNode(root);

        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.add(tarNode);
        visited.add(tarNode);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currNode = queue.remove();
                //left
                if (currNode.left != null && visited.add(currNode.left)) {
                    queue.add(currNode.left);

                }
                //right
                if (currNode.right != null && visited.add(currNode.right)) {
                    queue.add(currNode.right);

                }
                //upwards
                if (map.containsKey(currNode) && visited.add(map.get(currNode))) {
                    queue.add(map.get(currNode));
                }
            }
            minTime++;
        }
        return minTime - 1;
    }


    //    private static void findParent(Map<Node, Node> map, Queue<Node> queue) {
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Node currNode = queue.remove();
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
//    }
//
//
//
//
//    public static int minTime(Node root, int num) {
//        // Your code goes here
//
//        Map<Node, Node> map = new HashMap<>();
//        if (root == null) {
//            return 0;
//        }
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        findParent(map, queue);
//
//        Node target = findNode(root, num);
//        queue.add(target);
//        Map<Node, Boolean> visited = new HashMap<>();
//        visited.put(target, true);
//        int time = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            int checkCounter = 0;
//            for (int i = 0; i < size; i++) {
//                Node currNode = queue.remove();
//                if (currNode.left != null && !visited.containsKey(currNode.left)) {
//                    visited.put(currNode.left, true);
//                    queue.add(currNode.left);
//                    checkCounter++;
//                }
//
//                if (currNode.right != null && !visited.containsKey(currNode.right)) {
//                    visited.put(currNode.right, true);
//                    queue.add(currNode.right);
//                    checkCounter++;
//                }
//
//                Node parent = map.getOrDefault(currNode, null);
//                if (parent != null && !visited.containsKey(parent)) {
//                    visited.put(parent, true);
//                    queue.add(parent);
//                    checkCounter++;
//                }
//            }
//            if (checkCounter == 0) {
//               break;
//            }
//            time++;
//            //move radially in left,right and upward directions
//        }
//        return time;
//    }
//
//
    public List<Integer> inorderTraversal(Node root) {


        List<Integer> inorder = new ArrayList<>();
        if (root == null) {
            return inorder;
        }
        Stack<Node> treeStack = new Stack<>();
        Node curr = root;
        while (!treeStack.isEmpty() || curr != null) {
            if (curr != null) {
                treeStack.push(curr);
                curr = curr.left;
            } else {
                curr = treeStack.pop();
                inorder.add(curr.data);
                curr = curr.right;
            }
        }
        return inorder;

    }
}
