package com.practice.mycodeschool.ds;


class TreeNode {

    TreeNode left;
    Integer val;
    TreeNode right;

    TreeNode(int data){
        this.left=null;
        this.right=null;
        this.val=data;
    }
}

public class BinaryTree {

    TreeNode root;

    public TreeNode insert(TreeNode root,int data){
        if(root==null){
            TreeNode currNode=getNode(data);
            root=currNode;
        }else if(root.val < data){
            root.right=insert(root.right,data);
        }else{
            root.left=insert(root.left,data);
        }
        return root;
    }

    public TreeNode getNode(int data){
        TreeNode treeNode=new TreeNode(data);
        return treeNode;
    }

    public void add(int value) {
        root = insert(root, value);
    }

    public void preOrderTraversal(TreeNode root){
        if(root==null)
            return;
        System.out.printf(" %d ",root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }


    public void postOrderTraversal(TreeNode root){
        if(root==null)
            return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.printf(" %d ",root.val);
    }


    public void inOrderTraversal(TreeNode root){
        if(root==null)
            return;
        inOrderTraversal(root.left);
        System.out.printf(" %d ",root.val);
        inOrderTraversal(root.right);
    }


    public void preOrderTraversalCheck(){
        System.out.println("Started ***********:  Pre order traversal **************\n");
        preOrderTraversal(root);
        System.out.println("\nFinished ***********: Pre order traversal **************\n");
    }


    public void postOrderTraversalCheck(){
        System.out.println("Started ***********:  Post order traversal **************\n");
        postOrderTraversal(root);
        System.out.println("\nFinished ***********: Post order traversal **************\n");
    }


    public void inOrderTraversalCheck(){
        System.out.println("Started ***********:  In order traversal **************\n");
        inOrderTraversal(root);
        System.out.println("\nFinished ***********: In order traversal **************\n");
    }

    public boolean searchElement(TreeNode root,Integer element){
        if(root==null)
            return false;
        if(root.val < element){
            return searchElement(root.right,element);
        }else if(root.val > element){
            return searchElement(root.left,element);
        }else {
            return true;
        }
    }


    public void searchElement(Integer element){
        if(searchElement(root,element))
            System.out.println("Element found");
        else
            System.out.println("Not found!!!");
    }

    private int maxElement(TreeNode root) {
        if (root==null){
            System.out.println("Tree is empty");
            return -1;
        }
        while(root.right!=null){
            root=root.right;
        }
        return root.val;
    }

    public void maxElement() {
        System.out.println("Max element : "+maxElement(root));
    }

    private int minElement(TreeNode root) {
        if (root==null){
            System.out.println("Tree is empty");
            return -1;
        }
        while(root.left!=null){
            root=root.left;
        }
        return root.val;
    }

    public void minElement() {
        System.out.println("Min element : "+minElement(root));
    }

    private int heightOfTree(TreeNode root) {
        if (root==null)
            return 0;
        int left=heightOfTree(root.left);
        int right=heightOfTree(root.right);
        return Math.max(left,right)+1;
    }


    public void heightOfTree() {
        System.out.println("Height of binary tree: "+heightOfTree(root));
    }




    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(10);
        bt.add(20);
        bt.add(15);
        bt.add(40);
        bt.add(30);
        bt.add(70);
        bt.add(5);

        //  bt.preOrderTraversalCheck();
        //   bt.postOrderTraversalCheck();
        bt.inOrderTraversalCheck();


        bt.searchElement(5);
        bt.minElement();
        bt.maxElement();

        bt.heightOfTree();
    }
}
