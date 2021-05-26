package com.wangyc.algorithm.sorting;

import java.util.Arrays;

/**
 * 快速排序
 * @author wangyc
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {25, 84, 21, 47, 15, 27, 68, 35, 20};
        quick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 完成一次快速排序递归过程，直到排序最后过程
     * @param arr 待完成快速排序的数组
     * @param left 数组左下标
     * @param right 数组右下标
     */
    private static void quick(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            quick(arr, left, partition - 1);
            quick(arr, partition + 1, right);
        }
    }

    /**
     * 返回基准元素的下标
     * @param arr 快速排序的数组
     * @param left 数组左下标
     * @param right 数组右下标
     * @return 基准元素的下标
     */
    private static int partition(int[] arr, int left, int right) {
        //选取第一个元素为基准元素
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right --;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left ++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
}
