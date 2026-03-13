package com.paul.blind75;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-paths/description/">257. Binary Tree Paths</a>
 */
public class FindTreePath {

    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return List.of();
        List<String> list = new ArrayList<>();

        buildTreePath(root, "", list);

        return list;
    }


    private void buildTreePath(TreeNode node, String s, List<String> list) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            list.add(s + "" + node.val);
            return;
        }

        s = s + node.val + "->" ;
        buildTreePath(node.left, s, list);
        buildTreePath(node.right, s, list);
    }
}
