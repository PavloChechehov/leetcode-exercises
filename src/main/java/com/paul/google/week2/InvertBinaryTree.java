package com.paul.google.week2;

/**
 * <a href="https://leetcode.com/problems/invert-binary-tree/description/">226. Invert Binary Tree</a>
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode dummy = new TreeNode(root.val, switchNode(root.right), switchNode(root.left));
        return dummy;
    }

    public TreeNode switchNode(TreeNode node) {
        if (node == null) {
            return null;
        }

        return new TreeNode(node.val, switchNode(node.right), switchNode(node.left));
    }
}
