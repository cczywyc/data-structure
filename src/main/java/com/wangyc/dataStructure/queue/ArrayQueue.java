package com.wangyc.dataStructure.queue;

/**
 * 用数组模拟队列
 *
 * @author wangyc
 */
public class ArrayQueue {

    /** 数组的最大容量 */
    private int maxSize;
    /** 队列头 */
    private int front;
    /** 队列尾 */
    private int rear;
    /** 用来存放数据，模拟队列 */
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    /**
     * 判断队列是否为空
     * @return true：空队列 false：非空队列
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 判断队列是否为满
     * @return true：满队列 false：非满队列
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 向队列添加数据
     * @param n 添加的数据
     */
    public void addQueue(int n) {
        //判断队列是否为满
        if (isFull()) {
            System.out.println("The queue is full, can not add the " + n);
            return;
        }
        rear ++;
        arr[rear] = n;
    }

    /**
     * 获取队列的数据，出队列
     * @return 队列首的数据
     */
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty, can not get data");
        }
        front ++;
        return arr[front];
    }

    /**
     * 显示队列所有的数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty, can not get data");
        }
        return arr[front + 1];
    }
}
