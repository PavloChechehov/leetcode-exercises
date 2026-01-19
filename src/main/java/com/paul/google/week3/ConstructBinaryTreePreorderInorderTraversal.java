package com.paul.google.week3;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/">
 *     105. Construct Binary Tree from Preorder and Inorder Traversal</a>
 */
public class ConstructBinaryTreePreorderInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println();
    }


    private static Map<Integer, Integer> inorderMap;
    private static int[] preorderArr;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderArr = preorder;

        int len = preorder.length;

        inorderMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            inorderMap.put(inorder[i], i);
        }

        TreeNode root = build(0, len - 1, 0, len - 1);
        return root;
    }

    public static TreeNode build(int preL, int preR, int inL, int inR) {
        if (preL > preR) return null;

        int rootVal = preorderArr[preL];

        TreeNode root = new TreeNode(rootVal);

        int k = inorderMap.get(rootVal);

        int leftSize = k - inL;

        root.left = build(preL + 1, preL + leftSize, inL, k - 1);
        root.right = build(preL + leftSize + 1, preR, k + 1, inR);
        return root;
    }
}
