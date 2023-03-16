package com.wangyc.algorithm;

/**
 * heap sort
 * @author cczywyc
 */
public class HeapSort {

    public void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        // create heap
        buildHeap(arr);

        // sort
        int k = arr.length - 1;
        while (k > 0) {
            swap(arr, 0, k);
            heapify(arr, --k, 0);
        }
    }

    /**
     * create heap
     * @param arr arr
     */
    private void buildHeap(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            heapify(arr, arr.length - 1, i);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 + 1 <= n && arr[i] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (i * 2 + 2 <= n && arr[maxPos] < arr[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            if (maxPos == i) {
                break;
            }
            swap(arr, i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
