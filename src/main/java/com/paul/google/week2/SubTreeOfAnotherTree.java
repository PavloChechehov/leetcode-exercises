package com.paul.google.week2;

import java.util.ArrayDeque;
import java.util.Queue;


/**
 * <a href="https://leetcode.com/problems/subtree-of-another-tree/description/">572. Subtree of Another Tree</a>
 */
public class SubTreeOfAnotherTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(4, new TreeNode(1),
                new TreeNode(2, new TreeNode(0), null));
        root.right = new TreeNode(5);


        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));

        boolean res = isSubtree(root, subRoot);
        System.out.println(res);

    }

    //only DFS solution (more elegant approach), time complexity (O (n * m))
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base cases
        if (root == null && subRoot == null) return true;
        if (root == null) return false;

        // Check match at current node
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Recurse into left or right subtree
        return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    // BFS + DFS solution, time complexity (O (n * m))
/*
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();;
        queue.add(root);
        while(!queue.isEmpty()) {

            TreeNode curr = queue.poll();

            boolean res = isSameTree(curr, subRoot);

            if (res) {
                return true;
            } else if (curr != null) {
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }



        return false;
    }
*/

}

