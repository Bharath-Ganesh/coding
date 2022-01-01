package com.leetcode.trees;

import java.util.*;

class Pair {

    Node root;
    int index;

    Pair(Node node, int index) {
        this.root = node;
        this.index = index;
    }
}

public class TopViewOfBinaryTree {

    public static void main(String[] args) {
        TopViewOfBinaryTree obj = new TopViewOfBinaryTree();
        Node root = obj.createNode();
        System.out.println(obj.topView(root));
    }

    private Node createNode() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }


    static ArrayList<Integer> topView(Node root)
    {
        // add your code

        ArrayList<Integer> res=new ArrayList<>();
        Map<Integer,Node> map=new TreeMap<>();
        Pair rp=new Pair(root,0);
        Queue<Pair> queue=new LinkedList<>();
        queue.add(rp);
        PriorityQueue<Integer> pq=new PriorityQueue();
        pq.size();
        if(pq.isEmpty())
        while(!queue.isEmpty()){
            Pair p=queue.remove();
            int index=p.index;
            Node currNode=p.root;

            if(!map.containsKey(index)){
                map.put(index,currNode);
            }

            if(currNode.left!=null){
                queue.add(new Pair(currNode.left,index-1));
            }

            if(currNode.right!=null){
                queue.add(new Pair(currNode.right,index+1));
            }
        }

        for(Map.Entry<Integer,Node> entries : map.entrySet()){
            res.add(entries.getValue().data);
        }

        return res;

    }
}
