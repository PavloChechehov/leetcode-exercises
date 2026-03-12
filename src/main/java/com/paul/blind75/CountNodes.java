package com.paul.blind75;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/count-complete-tree-nodes/description/">222. Count Complete Tree Nodes</a>
 */
public class CountNodes {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);

        int counter = 0;

        while (!dq.isEmpty()) {

            int n = dq.size();

            for (int i = 0; i < n; i++) {

                TreeNode elem = dq.removeFirst();

                counter++;
                if (elem.left != null) dq.addLast(elem.left);
                if (elem.right != null) dq.addLast(elem.right);

            }

        }

        return counter;
    }
}
