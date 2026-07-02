package com.paul.exercises;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/walking-robot-simulation/description/">874. Walking Robot Simulation</a>
 */
public class WalkingRobotSimulation {


    public static void main(String[] args) {
//        int[] commands = {4,-1,3};
        int[] commands = {4,-1,4,-2,4};
//        int[] commands = {6,-1,-1,6};
//        int[][] obstacles = {};
        int[][] obstacles = {{2, 4}};
//        int[][] obstacles = {{0, 0}};
        int res = robotSim(commands, obstacles);
        System.out.println(res);
    }

    /*

    Input: commands = [4,-1,3], obstacles = []
    Output: 25

    1 <= k <= 9: Move forward k units, one unit at a time.

    * */

    public static int robotSim(int[] commands, int[][] obstacles) {
        // 0,0 -> x,y
        //obstacles[[1,2],[3,4]]

        // up -> (-2 = left, -1 = right)
        // down -> (-2 = right, -1 = left)
        // left -> (-2 = down, -1 = up)
        // right -> (-2 = up, -1 = down)

        HashMap<Character, Map<Integer, Character>> map = new HashMap<>();

        map.put('u', Map.of(-2, 'l', -1, 'r'));
        map.put('d', Map.of(-2, 'r', -1, 'l'));
        map.put('l', Map.of(-2, 'd', -1, 'u'));
        map.put('r', Map.of(-2, 'u', -1, 'd'));


        Map<Character, Direction> directions = new HashMap<>();
        directions.put('u', new Direction(0, 1));
        directions.put('l', new Direction(-1, 0));
        directions.put('r', new Direction(1, 0));
        directions.put('d', new Direction(0, -1));


        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }

        int maxDistSq = 0;
        int x = 0;
        int y = 0;
        char dir = 'u';

        for (int command : commands) {

            if (command == -1) {
                dir = map.get(dir).get(-1);
                continue;
            }

            if (command == -2) {
                dir = map.get(dir).get(-2);
                continue;
            }

            Direction direction = directions.get(dir);

            for (int i = 0; i < command; i++) {
                int nextX = x + direction.x();
                int nextY = y + direction.y();

                if (obstacleSet.contains(nextX + "," + nextY)) {
                    break;
                }

                x = nextX;
                y = nextY;

                maxDistSq = Math.max(maxDistSq, x * x + y * y);
            }
        }

        return maxDistSq;
    }
}

record Direction(int x, int y) {
}
