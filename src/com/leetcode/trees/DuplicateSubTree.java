package com.leetcode.trees;

import java.util.HashSet;

public class DuplicateSubTree {


    public static void main(String args[]) {
        DuplicateSubTree tree = new DuplicateSubTree();

        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */


        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

        Node node1 = tree.createNode1();
        String str = dupSub(node1);
        if(str.equals(""))
            System.out.print(" Yes ");
        else
            System.out.print(" No ");
    }

    public Node createNode1() {

        Node root = new Node('1');
        root.left = new Node('2');
        root.right = new Node('3');
        root.left.left = new Node('4');
        root.left.right = new Node('5');
        root.right.right = new Node('2');
        root.right.right.right = new Node('5');
        root.right.right.left= new Node('4');
        return root;
    }


    static char MARKER = '$';

    // This function returns empty string if tree
    // contains a duplicate subtree of size 2 or more.
    public static String dupSubUtil(Node root, HashSet<String> subtrees)
    {
        String s = "";

        // If current node is NULL, return marker
        if (root == null)
            return s + MARKER;

        // If left subtree has a duplicate subtree.
        String lStr = dupSubUtil(root.left,subtrees);
        if (lStr.equals(s))
            return s;

        // Do same for right subtree
        String rStr = dupSubUtil(root.right,subtrees);
        if (rStr.equals(s))
            return s;

        // Serialize current subtree
        s = s + root.data + lStr + rStr;

        // If current subtree already exists in hash
        // table. [Note that size of a serialized tree
        // with single node is 3 as it has two marker
        // nodes.
        if (s.length() > 3 && subtrees.contains(s))
            return "";

        subtrees.add(s);
        return s;
    }

    //Function to find if the Binary Tree contains duplicate
    //subtrees of size 2 or more
    public static String dupSub(Node root)
    {
        HashSet<String> subtrees=new HashSet<>();
        return dupSubUtil(root,subtrees);
    }


}
