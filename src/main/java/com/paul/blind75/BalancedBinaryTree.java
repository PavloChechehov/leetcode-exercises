package com.paul.blind75;


/**
 * <a href="https://leetcode.com/problems/balanced-binary-tree/description/">110. Balanced Binary Tree</a>
 */
class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        TreeNode left = root.left;
        TreeNode right = root.right;

        int res1 = findDepth(left, 0);
        int res2 = findDepth(right, 0);
        return Math.abs(res1 - res2) <= 1
                && isBalanced(left)
                && isBalanced(right);
    }

    private int findDepth(TreeNode node, int depth) {
        if (node == null)
            return depth;

        int leftDepth = findDepth(node.left, depth + 1);
        int rightDepth = findDepth(node.right, depth + 1);

        return Math.max(leftDepth, rightDepth);
    }
}
