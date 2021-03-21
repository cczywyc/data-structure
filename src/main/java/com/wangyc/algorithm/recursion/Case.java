package com.wangyc.algorithm.recursion;

/**
 *
 * 递归的两个案例
 *
 * @author wangyc
 */
public class Case {
    public static void main(String[] args) {
        //使用递归打印4次hello world
        printHello(4);
        //使用递归结算n的阶乘
        int result = getFactorial(4);
        System.out.println(result);
    }

    /**
     * 使用递归答应hello world
     * @param n 递归次数
     */
    private static void printHello(int n) {
        if (n > 1) {
            printHello(n -1);
        }
        System.out.println("Hello World!");
    }

    /**
     * 使用递归计算n的阶乘
     * @param n 计算阶乘
     * @return 结算结果
     */
    private static int getFactorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * getFactorial(n -1);
        }
    }
}