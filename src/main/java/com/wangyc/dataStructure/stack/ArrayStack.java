package com.wangyc.dataStructure.stack;

/**
 * 数组模拟栈
 *
 * @author wangyc
 */
public class ArrayStack {
    /** 栈的大小 */
    private final int maxSize;
    /** 栈顶指针 */
    private int top = -1;
    /** 数组，用来模拟栈 */
    private final int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 判断栈是否满
     * @return true：栈满  false：栈不满
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 判断栈是否为空
     * @return true：栈空   false：栈不为空
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     * @param value 要入栈的元素
     */
    public void push(int value) {
        //先判断栈是否为满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top ++ ;
        stack[top] = value;
    }

    /**
     * 出栈
     * @return 要出栈的元素
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据可以出栈");
        }
        top --;
        return stack[top];
    }

    /**
     * 遍历栈。遍历时需要栈顶遍历1
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
            return;
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
