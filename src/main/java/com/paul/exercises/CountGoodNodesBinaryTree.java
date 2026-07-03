package com.paul.exercises;

/**
 * <a href="https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/">1448. Count Good Nodes in Binary Tree</a>
 */
public class CountGoodNodesBinaryTree {

    public int goodNodes(TreeNode root) {
        if (root == null)
            return 0;

        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int maxValue) {
        if (root == null)
            return 0;

        int res = 0;

        if (root.val >= maxValue) {
            res += 1;
            maxValue = root.val;
        }

        return dfs(root.left, maxValue) + dfs(root.right, maxValue) + res;
    }
}
