package com.leetcode.trees;

public class ConstructBSTFromPreorder {

    public static void main(String[] args) {
        ConstructBSTFromPreorder obj = new ConstructBSTFromPreorder();
        int[] preorder = {8, 5, 1, 7, 10, 12};
        System.out.println(obj.bstFromPreorderBrute(preorder));
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int upperBound = Integer.MAX_VALUE;
        return bstFromPreorder(preorder, new int[]{0}, upperBound);
    }

    public TreeNode bstFromPreorder(int[] preorder, int[] index, int upperBound) {

        if (index[0] >= preorder.length || preorder[index[0]] > upperBound) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index[0]++]);
        root.left = bstFromPreorder(preorder, index, root.val);
        root.right = bstFromPreorder(preorder, index, upperBound);
        return root;
    }

    public TreeNode bstFromPreorderBrute(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int start, int end) {
        if(start > end) return null;

        TreeNode node = new TreeNode(preorder[start]);
        int i;
        for(i=start;i<=end;i++) {
            if(preorder[i] > node.val)
                break;
        }

        node.left = helper(preorder, start+1, i-1);
        node.right = helper(preorder, i, end);
        return node;



    }
}
