package com.paul.google.week3;

import java.util.PriorityQueue;


/**
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/">230. Kth Smallest Element in a BST</a>
 */
public class KthSmallestElement {
    public static void main(String[] args) {
        System.out.println("Hello");


    }


    /*public int kthSmallest(TreeNode root, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(root.val);
        dfs(root, queue);

        int i = 0;
        while (i < k - 1 && !queue.isEmpty()) {
            queue.poll();
            i++;
        }

        return queue.poll();
    }

    private void dfs(TreeNode root, PriorityQueue<Integer> queue) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            queue.add(root.left.val);
            dfs(root.left, queue);
        }

        if (root.right != null) {
            queue.add(root.right.val);
            dfs(root.right, queue);
        }
    }*/

    private int count;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        // Left
        inorder(node.left);

        // Visit
        count--;
        if (count == 0) {
            result = node.val;
            return;
        }

        // Right (only if we haven't found the answer)
        //
        inorder(node.right);
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
