package com.paul.google.week2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/invert-binary-tree/description/">226. Invert Binary Tree</a>
 */
public class InvertBinaryTree {

    //recursive approach
/*    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        return new TreeNode(root.val, invertTree(root.right), invertTree(root.left));
    }
*/

    //iteratively approach with using the Queue
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return root;
    }
}
