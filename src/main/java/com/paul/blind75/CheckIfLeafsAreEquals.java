package com.paul.blind75;


import java.util.ArrayList;
import java.util.List;


/**
 * <a href="https://leetcode.com/problems/leaf-similar-trees/description">872. Leaf-Similar Trees</a>
 */
public class CheckIfLeafsAreEquals {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        helper(root1, leaves1);
        helper(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    void helper(TreeNode node, List<Integer> list) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }

        helper(node.left, list);
        helper(node.right, list);
    }
}
