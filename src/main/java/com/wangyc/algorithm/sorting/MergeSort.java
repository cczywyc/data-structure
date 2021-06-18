package com.wangyc.algorithm.sorting;

import java.util.Arrays;

/**
 * merge sort
 * @author wangyc
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {5, 1, 6, 4, 3, 2};
        split(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    public static void split(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        split(l, mid);
        split(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
