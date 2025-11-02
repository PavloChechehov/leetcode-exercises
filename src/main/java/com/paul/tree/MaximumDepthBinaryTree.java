package com.paul.tree;


/**
 * Maximum Depth of Binary Tree <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">link</a>
 */
public class MaximumDepthBinaryTree {


    public class TreeNode {
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

    public int maxDepth(TreeNode root) {
        int res = dfs(root, 0);
        return res;
    }

    public int dfs(TreeNode root, int counter) {
        if (root == null) {
            return counter;
        }

        int left = dfs(root.left, counter + 1);
        int right = dfs(root.right, counter + 1);

        int res = Math.max(left, right);
        return res;
    }
}
