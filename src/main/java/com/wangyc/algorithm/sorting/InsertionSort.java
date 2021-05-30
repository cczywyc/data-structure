package com.wangyc.algorithm.sorting;

import java.util.Arrays;

/**
 * 插入排序
 * @author wangyc
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {14, 154, 13, 2, 45, 77, 1, 3};
        insertSort(arr);
    }

    public static void insertSort(int[] arr) {
        //插入的值
        int insertVal = 0;
        //插入的位置
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex --;
            }
            arr[insertIndex + 1] = insertVal;
            System.out.println(i);
            System.out.println(Arrays.toString(arr));
        }
    }
}
