package com.paul.blind75;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/description/">94. Binary Tree Inorder Traversal</a>
 */
class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        // 1 -> 2 -> 3
        //createLeft(root.left), root.val, creartRight(root.right);

        if (root == null) return List.of();

        List<Integer> leftPart = inorderTraversal(root.left);
        List<Integer> rightPart = inorderTraversal(root.right);

        List<Integer> res = new ArrayList<>(leftPart);

        res.add(root.val);
        res.addAll(rightPart);

        return res;
    }

}
