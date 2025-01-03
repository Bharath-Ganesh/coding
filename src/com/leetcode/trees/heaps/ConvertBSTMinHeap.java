package com.leetcode.trees.heaps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConvertBSTMinHeap {

    public static void main(String[] args) {
        Node node = constructTree();
        ConvertBSTMinHeap obj = new ConvertBSTMinHeap();
        Node root = obj.convertToMinHeap(node);
        System.out.println(root);
    }

    private static void arrToMinHeap(Node root, List<Integer> arr)
    {
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        int index=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                Node currNode=queue.remove();
                currNode.data=arr.get(index++);
                if(currNode.left!=null){
                    queue.add(currNode.left);
                }
                if(currNode.right!=null){
                    queue.add(currNode.right);
                }
            }
        }
    }

    public Node convertToMinHeap(Node root) {
        List<Integer> res=new ArrayList<>();
        bstToArray(root,res);
        int n=res.size();
        for(int i=(n/2)-1;i>=0;i--){
            heapify(res,i,n);
        }
        arrToMinHeap(root,res);
        return root;
    }

    private void heapify(List<Integer> res, int index, int n) {
        int smallest=index;
        int left=2*index+1;
        int right=2*index+2;
        if(left<n && res.get(left)<res.get(smallest)){
            smallest=left;
        }
        if(right<n && res.get(right)<res.get(smallest)){
            smallest=right;
        }
        if(smallest!=index){
            int temp=res.get(index);
            res.set(index,res.get(smallest));
            res.set(smallest,temp);
            heapify(res,smallest,n);
        }
    }

    private static void bstToArray(Node root, List<Integer> arr)
    {
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                Node currNode=queue.remove();
                arr.add(currNode.data);
                if(currNode.left!=null){
                    queue.add(currNode.left);
                }
                if(currNode.right!=null){
                    queue.add(currNode.right);
                }
            }
        }
    }

    public static Node constructTree() {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        return root;
    }
}
