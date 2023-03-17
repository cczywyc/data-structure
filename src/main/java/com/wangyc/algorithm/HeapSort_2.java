package com.wangyc.algorithm;

/**
 * heap sort
 * @author cczywyc
 */
public class HeapSort_2 {

    private void heapSort(int[] arr) {
        int len = arr.length - 1;
        buildMacHeap(arr, len);
        for (int i = len; i >= 1; --i) {
            swap(arr, i, 0);
            len -= 1;
            heapify(arr, 0, len);
        }
    }

    private void buildMacHeap(int[] arr, int len) {
        for (int i = len / 2; i >= 0; --i) {
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int i, int len) {
        while ((i << 1) + 1 <= len) {
            int large;
            int lson = (i << 1) + 1;
            int rson = (i << 1) + 2;
            if (lson <= len && arr[lson] > arr[i]) {
                large = lson;
            } else {
                large = i;
            }
            if (rson <= len && arr[rson] > arr[large]) {
                large = rson;
            }
            if (large != i) {
                swap(arr, i, large);
                i = large;
            } else {
                break;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
