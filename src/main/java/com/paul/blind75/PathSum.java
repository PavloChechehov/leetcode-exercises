package com.paul.blind75;


/**
 * <a href="https://leetcode.com/problems/path-sum/description/">112. Path Sum</a>
 */
class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        return findPathSum(root, targetSum);
    }

    private boolean findPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            return true;
        }

        boolean leftRes = findPathSum(root.left, targetSum - root.val);
        boolean rightRes = findPathSum(root.right, targetSum - root.val);

        return leftRes || rightRes;
    }
}
