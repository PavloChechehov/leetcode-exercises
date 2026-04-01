package com.paul.blind75;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;


/**
 * <a href="https://leetcode.com/problems/robot-collisions/description/">2751. Robot Collisions</a>
 */
public class RobotCollisions {

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Stack<Robot> stack = new Stack<>();
        int n = directions.length();

        List<Robot> robots = new ArrayList<>();
        //Position, Index?
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            robots.add(new Robot(positions[i], healths[i], directions.charAt(i)));
            map.put(positions[i], i);
        }

        robots.sort(Comparator.comparingInt(Robot::pos));

        for (int i = 0; i < n; i++) {
            Robot curr = robots.get(i);

            if (stack.isEmpty()
                    || stack.peek().dir() == curr.dir()
                    || (stack.peek().dir() == 'L' && curr.dir() == 'R')) {
                stack.add(curr);

            } else {

                //robot.dir == R
                // while (!stack.isEmpty() && stack.peek().dir() == 'R' && curr.dir() == 'L') {

                //     Robot robot = stack.pop();

                //     if (robot.health() == curr.health()) {
                //         curr == null;
                //         break;
                //     } else if (robot.health() > curr.health()) {
                //         stack.add(new Robot(robot.pos(), robot.health() - 1, robot.dir()));
                //     } else {
                //         stack.add(new Robot(curr.pos(), curr.health() - 1, curr.dir()));
                //     }
                // }

                while (!stack.isEmpty()
                        && stack.peek().dir() == 'R'
                        && curr.dir() == 'L') {

                    Robot robot = stack.pop();

                    if (robot.health() == curr.health()) {
                        curr = null; // both destroyed
                        break;
                    } else if (robot.health() > curr.health()) {
                        stack.add(new Robot(robot.pos(), robot.health() - 1, robot.dir()));
                        curr = null;
                        break;
                    } else {
                        curr = new Robot(curr.pos(), curr.health() - 1, curr.dir());
                    }
                }

                if (curr != null) {
                    stack.add(curr);
                }

            }

        }

        List<Integer> res = new ArrayList<>(Collections.nCopies(n, null));
        while (!stack.isEmpty()) {
            Robot curr = stack.pop();
            res.set(map.get(curr.pos()), curr.health());
        }

        return res.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

}

record Robot(int pos, int health, char dir) {

}
