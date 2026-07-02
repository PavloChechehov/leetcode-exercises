package com.paul.exercises;


import java.util.*;

public class TreeBuilder {

    public static void main(String[] args) {
        int[][] arr = {{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}};
        TreeNode res = createBinaryTree(arr);
        System.out.println(res);
    }

    public static TreeNode createBinaryTree(int[][] desc) {
        Set<Integer> childs = new HashSet<>();
        Map<Integer, Pair> map = new HashMap<>();
        // int n = des.length;

        for (int[] d : desc) {
            int parent = d[0];
            int child = d[1];
            int isLeft = d[2];//1 left

            if (map.containsKey(parent)) {
                Pair p = map.get(parent);

                if (isLeft == 1) {
                    p = new Pair(child, p.r());
                } else {
                    p = new Pair(p.l(), child);
                }

                map.put(parent, p);
            } else {

                Pair p;
                if (isLeft == 1) {
                    p = new Pair(child, null);
                } else {
                    p = new Pair(null, child);
                }
                map.put(parent, p);
            }

            childs.add(child);

        }

        Map<Integer, Pair> copy = new HashMap<>(map);

        Set<Integer> parents = map.keySet();
        parents.removeAll(childs);


        TreeNode node = new TreeNode();
        node.val = parents.iterator().next();

        TreeNode dummy = node;

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(node);

        while (!list.isEmpty()) {

            TreeNode curr = list.removeFirst();

            Pair pair = copy.get(curr.val);

            if (pair == null) continue;

            if (pair.l() != null) {
                curr.left = new TreeNode(pair.l());
                list.add(curr.left);

            }

            if (pair.r()!= null) {
                curr.right = new TreeNode(pair.r());
                list.add(curr.right);
            }

        }

        return dummy;
    }
}

record Pair(Integer l, Integer r) {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
