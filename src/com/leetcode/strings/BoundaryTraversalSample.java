package com.leetcode.strings;





import java.util.*;

public class BoundaryTraversalSample {

    public static void main(String[] args) {
        BoundaryTraversalSample obj = new BoundaryTraversalSample();
        Node root = obj.createNode3();
       // System.out.println(obj.inorderTraversal(root));
        System.out.println(obj.boundary(root));

    }

    //3 5 2 4 7 6 N 2 4 5 2 6 6 N 7 4 1 4 4 1 N 1 7
    private Node createNode3() {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.right.left = new Node(6);
        root.right.left.left = new Node(6);
        root.right.left.right = new Node(6);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(4);

        // root.left.left.left.left = new Node(1);
        root.left.left.left.right = new Node(7);

        root.left.left.right.left = new Node(4);
        root.left.left.right.right = new Node(1);

        root.left.right.right = new Node(2);
        root.left.right.left = new Node(5);

        root.left.right.left.left = new Node(4);
        root.left.right.left.right = new Node(4);

        root.left.right.right.left = new Node(1);

        root.right.left.left.left = new Node(1);
        root.right.left.left.right = new Node(7);
        return root;
    }

    class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    ArrayList <Integer> boundary(Node node)
    {
        ArrayList <Integer> res=new ArrayList<>();
        if(node==null) return res;
        if(node!=null && isLeafNode(node)) {
            res.add(node.data);
            return res;
        }

        addLeftBoundary(node,res);
        addLeafNodes(node,res);
        addRightBoundary(node,res);
        return res;
    }

    private void addLeftBoundary(Node node,ArrayList<Integer> res){

        while(!isLeafNode(node)){
            res.add(node.data);
            if(node.left!=null){
                node=node.left;
            }else{
                node=node.right;
            }
        }
    }

    private void addLeafNodes(Node node,ArrayList<Integer> res){

        if(node==null) return;
        if(isLeafNode(node)){
            res.add(node.data);
            return;
        }
        addLeafNodes(node.left,res);
        addLeafNodes(node.right,res);
    }

    private void addRightBoundary(Node node,ArrayList<Integer> res){
        node=node.right;
        if(node==null) return;
        Stack<Integer> stack=new Stack<>();
        while(!isLeafNode(node)){
            stack.push(node.data);
            if(node.right!=null){
                node=node.right;
            }else{
                node=node.left;
            }
        }

        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
    }

    private boolean isLeafNode(Node root){
        if(root.left==null && root.right==null) return true;
        return false;

    }



//    ArrayList<Integer> boundary(Node node)
//    {
//        ArrayList<Integer> res=new ArrayList<>();
//        if(node!=null){
//            res.add(node.data);
//        }
//        if(isLeaf(node)){
//            return res;
//        }
//        addLeft(node.left,res);
//        addLeaf(node,res);
//        addRight(node.right,res);
//        return res;
//    }
//
//    public boolean isLeaf(Node root){
//        if(root.left==null && root.right==null){
//            return true;
//        }
//        return false;
//    }
//
//    public void addLeft(Node curr,ArrayList<Integer> res){
//        while(curr!=null){
//            if(isLeaf(curr)){
//                return;
//            }
//            res.add(curr.data);
//            if(curr.left!=null){
//                curr=curr.left;
//            }else{
//                curr=curr.right;
//            }
//        }
//    }
//
//    public void addLeaf(Node node,ArrayList<Integer> res){
//        if(node==null){
//            return;
//        }
//        if(isLeaf(node)){
//            res.add(node.data);
//            return;
//        }
//        addLeaf(node.left,res);
//        addLeaf(node.right,res);
//    }
//
//    public void addRight(Node cur,ArrayList<Integer> res){
////        List<Integer> curList=new ArrayList<>();
////        while(curr!=null){
////            if(isLeaf(curr)){
////                return;
////            }
////            curList.add(curr.data);
////            if(curr.right!=null){
////                curr=curr.right;
////            }else{
////                curr=curr.left;
////            }
////        }
////        for(int i=curList.size()-1;i>=0;i--){
////            res.add(curList.get(i));
////        }
//
//
//        ArrayList<Integer> tmp = new ArrayList<>();
//        while (cur != null) {
//            if (isLeaf(cur) == false) {
//                tmp.add(cur.data);
//            }
//            if (cur.right != null){
//                cur = cur.right;
//            }
//            else {
//                cur = cur.left;
//            }
//        }
//        int i;
//        for (i = tmp.size() - 1; i >= 0; --i) {
//            res.add(tmp.get(i));
//        }
//    }
//
//    public List<Integer> inorderTraversal(Node root) {
//
//        PriorityQueue<Integer> pq=new PriorityQueue<>();
//        TreeMap<Integer, TreeMap<Integer,PriorityQueue>> map=new TreeMap<>();
//        for(Map.Entry<Integer,TreeMap<Integer,PriorityQueue>> s : map.entrySet()){
//            TreeMap<Integer, PriorityQueue> value = s.getValue();
//        }
//
//        List<Integer> inorder = new ArrayList<>();
//        if (root == null) {
//            return inorder;
//        }
//        Stack<Node> treeStack = new Stack<>();
//        Node curr = root;
//        while (!treeStack.isEmpty() || curr != null) {
//            if (curr != null) {
//                treeStack.push(curr);
//                curr = curr.left;
//            } else {
//                curr = treeStack.pop();
//                inorder.add(curr.data);
//                curr = curr.right;
//            }
//        }
//        return inorder;
//
//    }
}
