package com.paul.atlassian;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        SnakeGame snakeGame = new SnakeGameImpl(3, 3);


//        snakeGame.moveSnake(Directions.UP);
//        System.out.println(snakeGame.isGameOver());


        for (int i = 0; i < 10; i++) {
            snakeGame.moveSnake(Directions.RIGHT);
            snakeGame.moveSnake(Directions.DOWN);
            snakeGame.moveSnake(Directions.LEFT);
            snakeGame.moveSnake(Directions.UP);
        }


        System.out.println(snakeGame.getGrid());

        System.out.println(snakeGame.isGameOver());


    }
}

interface SnakeGame {
    void moveSnake(Directions d);

    //move to 4 directions
    boolean isGameOver();

    public int[][] getGrid();

}

//snake length equals to 3 - tail
// the game is over when the snake bite itself
//start - empty greed
//every 5 moves the snake increases in size +1
//apples
//the snake can go through the borders
//

class SnakeGameImpl implements SnakeGame {


    //1
    //0
    private int snakeSize = 3;
    private int[][] grid;
    private int counter = 0;
    private Position lastPos = new Position(0, 0);
    private int sizeBoard;
    private boolean gameIsOver;
    private LinkedList<Position> snakePositions = new LinkedList<>();


    public SnakeGameImpl(int snakeSize, int sizeBoard) {
        this.snakeSize = snakeSize;
        this.sizeBoard = sizeBoard;
        this.grid = new int[sizeBoard][sizeBoard];
        this.grid[0][0] = 1;
        snakePositions.add(new Position(0, 0));
        this.gameIsOver = false;
    }

    /*
| 1 0 0
| 0 0 0
| 0 0 0
*
* */

    public int[][] getGrid() {
        return grid;
    }


    @Override
    public void moveSnake(Directions d) {
        if (gameIsOver) {
            gameOverException();
        }

        // current head
        int row = lastPos.row();
        int col = lastPos.col();

        // wrapped movement
        int nextRow = (row + d.row + sizeBoard) % sizeBoard;
        int nextCol = (col + d.col + sizeBoard) % sizeBoard;

        Position newHead = new Position(nextRow, nextCol);

        boolean grow = (counter == 5);

        // 1. If NOT growing, remove tail BEFORE collision detection
        if (!grow) {
            Position tail = snakePositions.removeFirst();
            grid[tail.row()][tail.col()] = 0;
            counter++;
        } else {
            counter = 0;
        }

        // 2. Now safe to detect collision
        if (grid[nextRow][nextCol] == 1) {
            gameIsOver = true;
            gameOverException();
        }

        // 3. Add new head
        snakePositions.add(newHead);
        grid[nextRow][nextCol] = 1;

        lastPos = newHead;
    }

    private void gameOverException() {
        printGrid();
        throw new SnakeGameOverException("Game over!");
    }

    public void printGrid() {
        Arrays.stream(grid)
                .map(row -> Arrays.stream(row)
                        .boxed()
                        .toList())
                .forEach(System.out::println);
    }

/*
    @Override
    public void moveSnake(Directions d) {
        if (gameIsOver) {
            throw new SnakeGameOverException("The game is over!");
        }

        int row = lastPos.row();
        int col = lastPos.col();

        int currRow = row + d.row;
        // 2+3 , 0
        if (currRow < 0) {
            // 0,0 -> (-1, 0) -> (4,0)
            currRow = (currRow + sizeBoard) % sizeBoard;
        }

        if (currRow >= sizeBoard) {
            currRow = currRow % sizeBoard;
        }

        int currCol = col + d.col;
        if (currCol < 0) {
            currCol = (currCol + sizeBoard) % sizeBoard;
        }

        if (currCol >= sizeBoard) {
            currCol = currCol % sizeBoard;
        }

        if (grid[currRow][currCol] == 1) {
            gameIsOver = true;
        }

        Position currPosition = new Position(currRow, currCol);
        // null <-> 2
        // head -> 2

        if (counter == 5) {
            snakeSize++;
            counter = 0;
        } else {
            Position position = snakePositions.removeFirst();
            grid[position.row()][position.col()] = 0;
            counter++;
        }

        lastPos = currPosition;
        snakePositions.add(currPosition);
        grid[currPosition.row()][currPosition.col()] = 1;
    }
*/

    @Override
    public boolean isGameOver() {
        return gameIsOver;
    }
}

record Position(int row, int col) {

}

enum Directions {

    // greed[row][col]

    UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);

    // 0,0 -> (-1, 0) -> (4,0)
    //  5,0
    Directions(int row, int col) {
        this.row = row;
        this.col = col;
    }

    final int row;
    final int col;
}