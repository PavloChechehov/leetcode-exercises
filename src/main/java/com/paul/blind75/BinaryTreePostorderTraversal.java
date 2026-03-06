package com.paul.blind75;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/description/">145. Binary Tree Postorder Traversal</a>
 */
class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return List.of();

        List<Integer> list = new ArrayList<>();

        buildBinaries(root, list);
        return list;
    }

    private void buildBinaries(TreeNode root, List<Integer> list) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        buildBinaries(root.left, list);
        buildBinaries(root.right, list);

        list.add(root.val);
    }
}
