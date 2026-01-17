package com.paul.google.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum/description/">39. Combination Sum</a>
 */
public class CombinationSum {

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(candidates, 0, target, new ArrayList<>(), res);
            return res;
        }

        private void dfs(int[] candidates, int start, int remaining,
                         List<Integer> path, List<List<Integer>> res) {

            if (remaining == 0) {
                res.add(new ArrayList<>(path)); // copy!
                return;
            }

            if (remaining < 0) {
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                path.add(candidates[i]);
                dfs(candidates, i, remaining - candidates[i], path, res);
                path.remove(path.size() - 1);
            }
        }


/*
first incorrect approach
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            // Map<Integer, List<List<Integer>> memo = new Hash
            List<List<Integer>> res = new ArrayList<>();
            for(int i = 0; i < candidates.length; i++) {
                List<Integer> list = new ArrayList<>();
                List<Integer> combination = dfs(candidates, i, 0, target, list);
                if (combination != null) {
                    res.add(combination);
                }
            }

            return res;
        }


        public List<Integer> dfs(int[] candidates, int pos, int sum, int target, List<Integer> list){
            if (sum == target) {
                return list;
            }

            if (sum > target) {
                return null;
            }


            list.add(candidates[pos]);


            for(int i = pos; i < candidates.length; i++) {

                if(candidates[i] + sum <= target) {

                    List<Integer> res = dfs(candidates, i, sum + candidates[i], target, list);
                    if (res == null) {
                        return null;
                    }
                }

            }

            return null;
        }
*/
}
