package com.wangyc.dataStructure.stack;

/**
 * Doubly linked list implementation stack
 *
 * @author wangyc
 */
public class DoublyListStack {

    /** doubly linked list */
    DLinkedList dList;

    public DoublyListStack() {
        dList = new DLinkedList();
    }

    public void push(int val) {
        Node node = new Node(val);
        dList.addFirst(node);
    }

    public int pop() {
        int ans = peek();
        dList.deleteFirst();
        return ans;
    }

    public int peek() {
        return dList.getHead().val;
    }

    public void list() {
        // TODO
    }

    public class DLinkedList {
        Node head;
        Node tail;

        public DLinkedList() {
            head = new Node(0);
            tail = new Node(0);

            head.next = tail;
            tail.prev = head;
        }

        public Node getHead() {
            return head;
        }

        public void addFirst(Node node) {
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        }

        public void deleteFirst() {
            Node temp = head.next;
            head.next.prev = null;
            head.next = null;
            head = temp;
        }
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }
}
