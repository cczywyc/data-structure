package com.wangyc.algorithm.recursion;

/**
 * 使用递归解决迷宫问题。使用二维数组模拟迷宫
 * 问题描述：见notion：https://www.notion.so/fadbcc0cbad8477cb9381e06f3e4be1f
 *
 * @author wangyc
 */
public class Maze {
    /** 迷宫的行 */
    private static final int row = 8;
    /** 迷宫的列 */
    private static final int col = 7;

    public static void main(String[] args) {
        //使用二维数组来模拟迷宫。创建一个8行7列的迷宫
        int[][] maze = new int[row][col];

        setMaze(maze);
        showMaze(maze);
        System.out.println("=========【下右上左】递归走迷宫==========");
        setWay(maze, 1, 1);
        showMaze(maze);

        maze = new int[row][col];
        setMaze(maze);
        System.out.println("=========【上右下左】递归走迷宫==========");
        setWay2(maze, 1, 1);
        showMaze(maze);
    }

    /**
     * 初始化迷宫
     * @param maze 迷宫
     */
    private static void setMaze(int[][] maze) {
        //第一行和第八行都是墙
        for (int i = 0; i < col; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }

        //第一列和第七列都是墙
        for (int i = 0; i < row; i++) {
            maze[i][0] = 1;
            maze[i][6] = 1;
        }

        //第四行第二列和第四行第三列是墙
        maze[3][1] = 1;
        maze[3][2] = 1;
    }

    /**
     * 显示迷宫状态
     * @param maze 迷宫
     */
    private static void showMaze(int[][] maze) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 第一种走法。小球从坐标maze[1][1]出发，按照下、右、上、左的策略来走迷宫
     *
     * @param maze 迷宫
     * @param i 初始的行
     * @param j 初始的列
     * @return 能否走出去
     */
    private static boolean setWay(int[][] maze, int i, int j) {
        //递归结束的条件
        if (maze[6][5] == 2) {
            return true;
        } else {
            //不满足递归结束的条件，继续递归
            if (maze[i][j] == 0) {
                //格子为初始值0，代表没有走过这个格子
                maze[i][j] = 2;
                if (setWay(maze, i + 1, j)) {
                    //先向下走
                    return true;
                } else if (setWay(maze, i, j + 1)) {
                    //下走不通，向右走
                    return true;
                } else if (setWay(maze, i - 1, j)) {
                    //下右走不通，上走
                    return true;
                } else if (setWay(maze, i, j - 1)) {
                    //左走
                    return true;
                } else {
                    //如果上下左右都走不通，代表是思路，走不通
                    maze[i][j] = 3;
                    return false;
                }
            } else {
                //格子值为1/2/3,由于这里没有回溯算法，该迷宫永远走不通
                return false;
            }
        }
    }

    /**
     * 第二种走法。小球从坐标maze[1][1]出发，按照上、右、下、左的策略来走迷宫
     *
     * @param maze 迷宫
     * @param i 初始的行
     * @param j 初始的列
     * @return 能否走出去
     */
    private static boolean setWay2(int[][] maze, int i, int j) {
        //递归结束的条件
        if (maze[6][5] == 2) {
            return true;
        } else {
            //不满足递归结束的条件，继续递归
            if (maze[i][j] == 0) {
                //格子为初始值0，代表没有走过这个格子
                maze[i][j] = 2;
                if (setWay2(maze, i - 1, j)) {
                    //先向上走
                    return true;
                } else if (setWay2(maze, i, j + 1)) {
                    //上走不通，向右走
                    return true;
                } else if (setWay2(maze, i + 1, j)) {
                    //上右走不通，下走
                    return true;
                } else if (setWay2(maze, i, j - 1)) {
                    //左走
                    return true;
                } else {
                    //如果上下左右都走不通，代表是思路，走不通
                    maze[i][j] = 3;
                    return false;
                }
            } else {
                //格子值为1/2/3,由于这里没有回溯算法，该迷宫永远走不通
                return false;
            }
        }
    }
}
