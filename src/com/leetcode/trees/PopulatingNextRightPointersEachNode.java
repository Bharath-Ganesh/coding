package com.leetcode.trees;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 116. Populating Next Right Pointers in Each Node
 */

class TreeNodeNext {

    public TreeNodeNext left;
    public TreeNodeNext right;
    public TreeNodeNext next;
    public Integer val;

    public TreeNodeNext(int val) {
        this.left = null;
        this.right = null;
        this.next = null;
        this.val = val;
    }

    TreeNodeNext(int val, TreeNodeNext left, TreeNodeNext right, TreeNodeNext next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}

public class PopulatingNextRightPointersEachNode {

    public static void main(String[] args) {
        PopulatingNextRightPointersEachNode obj = new PopulatingNextRightPointersEachNode();
        TreeNodeNext root = obj.createNode();
        obj.connect(root);
    }

    private TreeNodeNext createNode() {
        TreeNodeNext root = new TreeNodeNext(1);
        root.left = new TreeNodeNext(2);
        root.right = new TreeNodeNext(3);
        root.left.left = new TreeNodeNext(4);
        root.left.right = new TreeNodeNext(5);
        root.right.left = new TreeNodeNext(6);
        root.right.right = new TreeNodeNext(7);
        return root;
    }

    public void connect(TreeNodeNext root) {
        if (root == null) return;
        TreeNodeNext pre = root;
        TreeNodeNext cur = null;
        while (pre.left != null) {
            cur = pre;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            pre = pre.left;
        }
    }
}
