package com.paul.blind75;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/sum-of-left-leaves/description/">404. Sum of Left Leaves</a>
 */
public class SumOfLeftLeaves {

    //complexity O(n)
    public int sumOfLeftLeaves(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        calculateSum(root, false, list);

        int sum = 0;
        for (Integer v : list) {
            sum += v;
        }

        return sum;
    }

    private void calculateSum(TreeNode node, boolean isLeft, List<Integer> list) {
        if (node == null) return;

        if (node.left == null && node.right == null && isLeft) {
            list.add(node.val);
        }

        calculateSum(node.left, true, list);
        calculateSum(node.right, false, list);
    }
}
