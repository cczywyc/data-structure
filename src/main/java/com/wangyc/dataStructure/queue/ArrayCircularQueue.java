package com.wangyc.dataStructure.queue;

/**
 * 数组模拟环形队列
 *
 * @author wangyc
 */
public class ArrayCircularQueue {
    /** 队列的最大容量 */
    private int maxSize;
    /** 队列头的位置指针 */
    private int front;
    /** 队列尾的位置指正 */
    private int rear;
    /** 数组存放数据，模拟队列 */
    private int[] arr;

    public ArrayCircularQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否为满
     * @return true：满队列 false：空队列
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     * @return true：空队列 false：非空队列
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到环形队列
     * @param n 添加的数据
     */
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("The queue is full, can not add the " + n);
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 从队列中取数据，出队列
     * @return 取出的数据
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty, can not get data");
        }
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    /**
     * 显示队列所有的数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty");
            return;
        }
        for (int i = front; i < front + effectiveSize(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 求出当前队列有效数据的个数
     * @return 有效数据的个数
     */
    public int effectiveSize() {
        return (rear - front + maxSize) % maxSize;
    }

    /**
     * 显示队列的头数据，不是取数据
     * @return 队列的头数据
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty, can not get data");
        }
        return arr[front];
    }
}
