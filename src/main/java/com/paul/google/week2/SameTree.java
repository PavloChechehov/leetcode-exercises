package com.paul.google.week2;

/**
 * <a href="https://leetcode.com/problems/same-tree/description">100. Same Tree</a>
 */
public class SameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode();
        TreeNode q = new TreeNode();
        boolean isSameTree = isSameTree(p, q);
        System.out.println(isSameTree);

    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val == q.val) {
            return isSameTree(p.left, q.left);
        }

        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
