package com.wangyc.algorithm.recursion;

/**
 * 使用递归求解八皇后问题（回溯算法）
 *
 * @author wangyc
 */
public class EightQueens {
    /** 一共8个皇后 */
    private static final int max = 8;
    /** 一维数组存放8个皇后在棋盘的摆放位置，索引代表行，值代表列 */
    private static final int[] arr = new int[8];
    /** 计数，共有多少种解法 */
    private static int sum = 0;

    public static void main(String[] args) {
        check(0);
        System.out.println("The total solutions are:" + sum);
    }

    /**
     * 开始摆放皇后，回溯算法
     * @param n 当前准备摆放的皇后的索引值，也就是行数
     */
    private static void check(int n) {
        //递归结束的条件是第8行的皇后摆放完毕
        if (n == max) {
            sum++;
            showArr();
            return;
        }
        for (int i = 0; i < max; i++) {
            //开始摆放
            arr[n] = i;
            if (isReasonable(n)) {
                //摆放合理，开始下一次摆放
                check(n + 1);
            }
        }
    }

    /**
     * 判断当前摆放的皇后是否和之前摆放的有冲突
     * @param n 当前即将摆放的皇后索引值（行数）
     * @return 是否冲突
     */
    private static boolean isReasonable(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                //同一列或者对角线
                return false;
            }
        }
        return true;
    }

    /**
     * 打印数组
     */
    private static void showArr() {
        for (int i = 0; i < max; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
