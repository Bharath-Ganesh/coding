package com.leetcode.trees;


class TreeNode {
    TreeNode left;
    TreeNode right;
    Integer val;

    TreeNode(int val) {
        this.left = null;
        this.right = null;
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class BinaryTree {

    private TreeNode root1;
    private TreeNode root2=new TreeNode(6);

    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.createBinarySearchTree();

//        binaryTree.createBinaryTree();
//        binaryTree.inOrderTraversal(binaryTree.root2);

    }

    private void createBinaryTree() {
        root2.left=new TreeNode(4);
        root2.right=new TreeNode(15);
        root2.left.left=new TreeNode(7);
        TreeNode treeNode1=new TreeNode(12);
        TreeNode treeNode2=new TreeNode(26);
        root2.right.right=treeNode1;
        root2.right.left=treeNode2;

    }

    private void createBinarySearchTree() {
        addBinarySearchTree(1);
        addBinarySearchTree(5);
        addBinarySearchTree(8);
        addBinarySearchTree(2);
        addBinarySearchTree(4);
        inOrderTraversal(root1);
    }


    private void addBinarySearchTree(int value) {
        root1 = createBinarySearchTree(root1, value);
    }


    public TreeNode createBinarySearchTree(TreeNode root1,int value) {
        if(root1==null){
            return new TreeNode(value);
        }
        if(value>root1.val){
            root1.right=createBinarySearchTree(root1.right,value);
        }else{
            root1.left=createBinarySearchTree(root1.left,value);
        }
        return  root1;
    }


    public void preOrderTraversal(TreeNode root1){
        if(root1==null)
            return;
        System.out.printf(" %d ",root1.val);
        preOrderTraversal(root1.left);
        preOrderTraversal(root1.right);
    }


    public void postOrderTraversal(TreeNode root1){
        if(root1==null)
            return;
        postOrderTraversal(root1.left);
        postOrderTraversal(root1.right);
        System.out.printf(" %d ",root1.val);
    }


    public void inOrderTraversal(TreeNode root1){
        if(root1==null)
            return;
        inOrderTraversal(root1.left);
        System.out.printf(" %d ",root1.val);
        inOrderTraversal(root1.right);
    }


    public void preOrderTraversalCheck(){
        System.out.println("Started ***********:  Pre order traversal **************\n");
        preOrderTraversal(root1);
        System.out.println("\nFinished ***********: Pre order traversal **************\n");
    }


    public void postOrderTraversalCheck(){
        System.out.println("Started ***********:  Post order traversal **************\n");
        postOrderTraversal(root1);
        System.out.println("\nFinished ***********: Post order traversal **************\n");
    }


    public void inOrderTraversalCheck(){
        System.out.println("Started ***********:  In order traversal **************\n");
        inOrderTraversal(root1);
        System.out.println("\nFinished ***********: In order traversal **************\n");
    }
}
