package com.paul.exercises;


import java.util.Arrays;

public class Robot {

    public static void main(String[] args) {

        Robot robot = new Robot(6, 3);
//        ["Robot", "step", "step", "getPos", "getDir", "step", "step", "step", "getPos", "getDir"]
//        [[6, 3], [2], [2], [], [], [2], [1], [4], [], []]
        robot.step(2);
        robot.step(2);
        System.out.println(Arrays.toString(robot.getPos()));
        System.out.println(robot.getDir());
        robot.step(2);
        robot.step(1);
        robot.step(4);
        System.out.println(Arrays.toString(robot.getPos()));
        System.out.println(robot.getDir());
    }


    private int width, height;
    private int x = 0, y = 0;
    private int dir = 0; // 0=East, 1=North, 2=West, 3=South
    private boolean hasMoved = false;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void step(int num) {
        int perimeter = 2 * (width + height) - 4;
        num %= perimeter;

        if (num == 0 && x == 0 && y == 0) {
            dir = 3; // South
        }

        hasMoved = true;
        if (num == 0)
            return;

        while (num > 0) {
            if (dir == 0) { // East
                int move = Math.min(num, width - 1 - x);
                x += move;
                num -= move;
                if (x == width - 1 && num > 0)
                    dir = 1;
            } else if (dir == 1) { // North
                int move = Math.min(num, height - 1 - y);
                y += move;
                num -= move;
                if (y == height - 1 && num > 0)
                    dir = 2;
            } else if (dir == 2) { // West
                int move = Math.min(num, x);
                x -= move;
                num -= move;
                if (x == 0 && num > 0)
                    dir = 3;
            } else { // South
                int move = Math.min(num, y);
                y -= move;
                num -= move;
                if (y == 0 && num > 0)
                    dir = 0;
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        return switch (dir) {
            case 0 -> "East";
            case 1 -> "North";
            case 2 -> "West";
            case 3 -> "South";
            default -> "";
        };
    }

}
