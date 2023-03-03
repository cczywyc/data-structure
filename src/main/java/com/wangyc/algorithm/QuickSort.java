package com.wangyc.algorithm;

/**
 * quick sort
 *
 * @author cczywyc
 */
public class QuickSort {

    public void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (right >= left) return;
        int partition = partition(arr, left, right);
        quickSort(arr, left, partition);
        quickSort(arr, partition + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (right > left && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
            arr[left] = pivot;
        }
        return left;
    }
}
