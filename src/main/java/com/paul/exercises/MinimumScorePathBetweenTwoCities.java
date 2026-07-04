package com.paul.exercises;


import java.util.*;

/**
 * <a href="https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/description">2492. Minimum Score of a Path Between Two Cities</a>
 */
public class MinimumScorePathBetweenTwoCities {


    public static int minScore(int n, int[][] roads) {
        // Build the graph as an adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int distance = road[2];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(new int[]{b, distance});
            graph.get(b).add(new int[]{a, distance});
        }

        // Use BFS or DFS to find the minimum score path from 1 to n
        return bfsMinScore(graph, n);
    }

    private static int bfsMinScore(Map<Integer, List<int[]>> graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int minScore = Integer.MAX_VALUE;

        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int city = queue.poll();
            for (int[] neighbor : graph.get(city)) {
                int nextCity = neighbor[0];
                int roadDistance = neighbor[1];

                minScore = Math.min(minScore, roadDistance);

                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    queue.offer(nextCity);
                }
            }
        }

        return minScore;
    }

    public static void main(String[] args) {
        int n = 4; // Number of cities
        int[][] roads = {{1, 2, 3}, {2, 3, 4}, {3, 4, 5}, {1, 4, 10}}; // Roads between cities
        System.out.println(minScore(n, roads)); // Output the minimum score of the path
    }
}
