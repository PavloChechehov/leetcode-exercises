package com.paul.atlassian;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestor {


    public static void main(String[] args) {
        Node parent = new Node(5);
        Node n3 = new Node(3);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n4 = new Node(4);
        n4.parent = parent;
        n3.parent = parent;
        n1.parent = n3;
        n2.parent = n3;

        Node res = lowestCommonAncestor(n1, n4);

        System.out.println(res);
    }


    //second solution
    public static Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> visited = new HashSet<>();

        while (p != null) {
            visited.add(p);
            p = p.parent;
        }

        while (q != null) {
            if (visited.contains(q)) return q;
            q = q.parent;
        }

        return null; // unreachable for valid input
    }



    // chatgpt answer:
    /*public static Node lowestCommonAncestor(Node p, Node q) {
        Node a = p;
        Node b = q;

        while (a != b) {
            if (a.parent != null) {
                a = a.parent;
            } else {
                a = q;
            }

            if (b.parent != null){
                b = b.parent;
            }  else {
                b = p;

            }
        }

        return a;  // or b
    }*/


/*
    public static Node lowestHelper(Node p, Node q, Map<Integer, Node> map, int minValue) {

        if (map.get(p.parent.val) != null) {
            return map.get(p.parent.val);
        }

        if (map.get(q.parent.val) != null) {
            return map.get(q.parent.val);
        }

        if (p.parent.val == q.parent.val) {
            return p.parent;
        }

        Node parent1 = lowestHelper(p.parent, q, map, minValue);
        Node parent2 = lowestHelper(p, q.parent, map, minValue);


        map.put(parent1.val, parent1);
        map.put(parent2.val, parent2);

        return parent1;


    }

    public static Node lowestCommonAncestor(Node p, Node q) {
        return lowestHelper(p, q, new HashMap<>(), Integer.MAX_VALUE);
    }*/
}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;

    public Node(int val){
        this.val = val;
    }


    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", parent=" + parent +
                '}';
    }
}