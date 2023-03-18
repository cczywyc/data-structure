package com.wangyc.algorithm;

/**
 * heap sort
 *
 * @author cczywyc
 */
public class HeapSort_3 {

    private void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int length = arr.length;
        for (int i = length - 1; i >= 0; i--) {
            heapify(arr, i, length);
        }
        swap(arr, 0, --length);
        while (length > 0) {
            heapify(arr, 0, length);
            swap(arr, 0, --length);
        }
    }

    private void heapify(int[] arr, int index, int length) {
        int left = index * 2 + 1;
        while (left < length) {
            int largest = left + 1 < length && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) break;
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
