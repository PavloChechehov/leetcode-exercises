package com.paul.google.week3;

import java.util.ArrayList;
import java.util.List;

public class ClimbStairs {

    public static void main(String[] args) {
        int res = climbStairs(5);
        System.out.println(res == 8);

        int res1 = climbStairs(6);
        System.out.println(res1 == 13);
    }


    //fibonacci problem
/*     public int climbStairs(int n) {
         //stairs [1,2,3,4,5]
         // 1, 2
         // [0,1,2,3,4,5]

         //if curr > n return ;
         // if curr == n return 1;
         //
         // O(n) + O(n) -> O(k * n)
         // res1 = climbStairs(curr + 1) + 1);
         // res2 = climbStairs(curr  + 2) + 1;
         // return res1 + res2;

         // 1 = 1  n = 1
         // 2  = 1,2 | 0->2 n = 2
         // 3 = 0,1,2,3 | 0,2,3 | 0,1,3 n = 3
         // 4 -> 0,1,2,3,4 | 1,2,4 | 2,4 | 2,3,4 | 1,3,4    n = 5
         // 5 -> (n - 1) + (n - 2) = 8
         Map<Integer, Integer> map = new HashMap<Integer, Integer>();
         return helpFunction(n, map);
     }*/

    //recursion
/*
     private Integer helpFunction(int n, Map<Integer, Integer> map) {
         if(map.containsKey(n)) return map.get(n);

         if (n == 1) return 1;
         if (n == 2) return 2;

         int res = helpFunction(n - 1, map) + helpFunction(n - 2, map);

         map.put(n, res);

         return res;
     }*/


    //iteration 1
    // public int climbStairs(int n) {
    //     int a = 0;
    //     int b = 1;

    //     int temp = 0;
    //     for(int i = 0; i < n; i ++) {
    //         temp = a + b;
    //         a = b;
    //         b = temp;
    //     }

    //     return b;
    // }

    //iteration 2
    public static int climbStairs(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        int size = list.size();
        for (int i = 0; i < n; i++) {
            list.add(list.get(size - 1) + list.get(size - 2));
            size++;
        }

        return list.get(size - 1);
    }

}
