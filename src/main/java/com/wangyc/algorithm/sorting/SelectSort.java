package com.wangyc.algorithm.sorting;

import java.util.Arrays;

/**
 * 选择排序
 * @author wangyc
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {2, 104, 43, 103, 15, 77};
        select(arr);
    }

    private static void select(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            //最小值与交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第" + (i + 1) + "论后");
            System.out.println(Arrays.toString(arr));
        }
    }
}
