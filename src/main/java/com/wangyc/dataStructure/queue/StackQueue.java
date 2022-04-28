package com.wangyc.dataStructure.queue;

import java.util.Objects;
import java.util.Stack;

/**
 * stack implementation queue
 *
 * @author wangyc
 */
public class StackQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;
    private int front;

    public StackQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if (s1.isEmpty()) {
            front = x;
        }
        s1.push(x);
    }

    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if (!s2.isEmpty()) {
            s2.peek();
        }
        return front;
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
