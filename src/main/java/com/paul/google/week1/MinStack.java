package com.paul.google.week1;

import java.util.ArrayList;


/**
 * <a href="https://leetcode.com/problems/min-stack/description/">155. Min Stack</a>
 */

record MinValue(int min, int val) {

}

public class MinStack {
    ArrayList<MinValue> minLists;

    public MinStack() {
        this.minLists = new ArrayList<>();
    }

    public void push(int val) {
        if (minLists.isEmpty()) {
            minLists.add(new MinValue(val, val));
        } else {
            Integer lastMin = minLists.getLast().min();

            if (lastMin > val) {
                minLists.add(new MinValue(val, val));
            } else {
                minLists.add(new MinValue(lastMin, val));
            }
        }
    }

    public void pop() {
        minLists.removeLast();
    }

    public int top() {
        return minLists.getLast().val();
    }

    public int getMin() {
        return minLists.getLast().min();
    }

//brute force approach
/*    ArrayList<Integer> minLists;
    ArrayList<Integer> elements;

    public MinStack() {
        this.minLists = new ArrayList<>();
        this.elements = new ArrayList<>();
        // this.val = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (minLists.isEmpty()) {
            minLists.add(val);
        } else {
            Integer last = minLists.getLast();

            if (last > val) {
                minLists.add(val);
            } else {
                minLists.add(last);
            }
        }

        elements.add(val);
        System.out.println();
    }

    public void pop() {
        elements.removeLast();
        minLists.removeLast();
    }

    public int top() {
        return elements.getLast();
    }

    public int getMin() {
        return minLists.getLast();
    }*/

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(-0);
        minStack.push(-3);

        int min = minStack.getMin();
        System.out.println(min);
        minStack.pop();
        int top = minStack.top();
        System.out.println(top);

    }
}

