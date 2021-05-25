package com.wangyc.algorithm.sorting;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author wangyc
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 1, 8, 3};
        System.out.println("排序前的原始数组为：" + Arrays.toString(arr));
        int temp = 0;
        //标识符，代表本次大循环是否发生了交换，如果没有发生交换，则代表当前已经有序，直接退出循环
        boolean flag = false;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
            System.out.println("第" + i + "论排序后的数组为");
            System.out.println(Arrays.toString(arr));
        }
    }
}
