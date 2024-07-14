package com.wangyc.dataStructure.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Basic operations on a heap
 *
 * @author cczywyc
 */

public class MyHeap {

    public static void main(String[] args) {
        Queue<Integer> minHeap = new PriorityQueue<>();

        // init the max heap
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        maxHeap.offer(1);
        maxHeap.offer(3);
        maxHeap.offer(2);
        maxHeap.offer(5);
        maxHeap.offer(4);
        System.out.println(maxHeap);

        Integer peek = maxHeap.peek();
        System.out.println(peek);

        System.out.println("The heap size is: " + maxHeap.size());

        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());

        System.out.println("The heap size is: " + maxHeap.size());
        System.out.println(maxHeap.isEmpty());

        // input array and build a minHeap
        minHeap = new PriorityQueue<>(Arrays.asList(5, 4, 3, 2, 1));
        System.out.println(minHeap);
    }

}
