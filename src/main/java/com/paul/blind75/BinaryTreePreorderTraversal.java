package com.paul.blind75;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/description/">144. Binary Tree Preorder Traversal</a>
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return List.of();

        List<Integer> list = new ArrayList<>();

        buildBinaryTree(root, list);

        return list;
    }

    private void buildBinaryTree(TreeNode root, List<Integer> list) {
        if (root == null) return;

        list.add(root.val);

        buildBinaryTree(root.left, list);
        buildBinaryTree(root.right, list);
    }

}
