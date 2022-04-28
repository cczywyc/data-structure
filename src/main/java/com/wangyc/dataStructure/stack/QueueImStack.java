package com.wangyc.dataStructure.stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * use queue implementation stack
 *
 * @author wangyc
 */
public class QueueImStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    private int rear;

    public QueueImStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public void push(int x) {
        if (q1.isEmpty()) {
            q1.add(x);
            while (!q2.isEmpty()) {
                q1.add(q2.remove());
            }
        } else {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
        }
    }

    public int pop() {
        if (!q1.isEmpty()) {
            return q1.remove();
        } else {
            return q2.remove();
        }
    }

    public int top() {
        if (!q1.isEmpty()) {
            return q1.peek();
        } else {
            return q2.peek();
        }
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
