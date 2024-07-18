package com.wangyc.dataStructure.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementing a heap with an array
 *
 * @author cczywyc
 */

public class HeapUsingArray {

    private List<Integer> maxHeap;

    public HeapUsingArray(List<Integer> nums) {
        maxHeap = new ArrayList<>(nums);
        for (int i = getParent(maxHeap.size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    int getLeftIndex(int i) {
        return 2 * i + 1;
    }

    int getRightIndex(int i) {
        return 2 * i + 2;
    }

    int getParent(int i) {
        return (i - 1) / 2;
    }

    int peek() {
        return maxHeap.get(0);
    }

    void push(int val) {
        maxHeap.add(val);
        siftUp(maxHeap.size() - 1);
    }

    int pop() {
        if (maxHeap.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        swap(0, maxHeap.size() - 1);
        Integer val = maxHeap.remove(maxHeap.size() - 1);
        siftDown(0);
        return val;
    }

    /**
     * heapify from bottom to top
     *
     * @param i index
     */
    void siftUp(int i) {
        while (true) {
            int parent = getParent(i);
            if (parent < 0 || maxHeap.get(i) <= maxHeap.get(parent)) {
                break;
            }
            swap(i, parent);
            i = parent;
        }
    }

    void siftDown(int i) {
        while (true) {
            int left = getLeftIndex(i);
            int right = getRightIndex(i);
            int largest = i;
            if (left < maxHeap.size() && maxHeap.get(left) > maxHeap.get(largest)) {
                largest = left;
            }
            if (right < maxHeap.size() && maxHeap.get(right) > maxHeap.get(largest)) {
                largest = right;
            }
            if (largest == i) {
                break;
            }
            swap(i, largest);
            i = largest;
        }
    }

    void swap(int i, int j) {
        int temp = maxHeap.get(i);
        maxHeap.set(i, maxHeap.get(j));
        maxHeap.set(j, temp);
    }
}
