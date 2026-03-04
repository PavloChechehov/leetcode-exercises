package com.paul.blind75;


/**
 * <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/description/">111. Minimum Depth of Binary Tree</a>
 */
class MinimumDepthBinaryTree {
    //bfs solution

    // public int minDepth(TreeNode root) {
    //     if (root == null)
    //         return 0;

    //     Deque<TreeNode> nodes = new ArrayDeque<>();
    //     nodes.add(root);

    //     int height = 1;

    //     while (!nodes.isEmpty()) {

    //         int n = nodes.size();

    //         for (int i = 0; i < n; i++) {

    //             TreeNode curr = nodes.getFirst();

    //             if (curr.left == null && curr.right == null) {
    //                 return height;
    //             }

    //             if (curr.left != null) {
    //                 nodes.add(curr.left);
    //             }

    //             if (curr.right != null) {
    //                 nodes.add(curr.right);
    //             }

    //             nodes.removeFirst();
    //         }
    //         height++;
    //     }

    //     return height;
    // }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        return findDepth(root, 1);
    }

    //or use the dfs
    private int findDepth(TreeNode node, int depth) {
        if (node == null)
            return Integer.MAX_VALUE;


        if (node.left == null && node.right == null) {
            return depth;
        }

        int left = findDepth(node.left, depth + 1);
        int right = findDepth(node.right, depth + 1);

        return Math.min(left, right);

    }
}
