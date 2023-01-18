package com.wangyc.dataStructure.linkedList;

/**
 * lru algorithm base linkedList
 *
 * @author cczyWyc
 */
public class LRUBaseLinkedList<T> {
    /** default capacity */
    private final static int DEFAULT_CAPACITY = 10;
    /** length of the list */
    private int length;
    /** capacity of the list */
    private int capacity;
    /** head node of the list */
    private Node<T> headNode;

    public LRUBaseLinkedList() {
        this.headNode = new Node<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(int capacity) {
        this.capacity = capacity;
        this.headNode = new Node<>();
        this.length = 0;
    }

    /**
     * add element
     * @param data data
     */
    public void add(T data) {
        //get preNode
        Node preNode = getPreNode(data);
        if (preNode != null) {
            deleteElement(preNode);
            addElementHead(data);
        } else {
            if (length >= this.capacity) {
                //delete the last element
                deleteLastElement();
            }
            addElementHead(data);
        }
    }

    /**
     * delete element
     * @param preNode it preNOde
     */
    private void deleteElement(Node preNode) {
        Node temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        length--;
    }

    /**
     * add element to list head
     * @param data the add element
     */
    private void addElementHead(T data) {
        Node next = headNode.getNext();
        headNode.setNext(new Node(data, next));
        length++;
    }

    /**
     * delete the last element of the list
     */
    private void deleteLastElement() {
        Node preNode = headNode;
        if (preNode.getNext() == null) {
            return;
        }

        while (preNode.getNext().getNext() != null) {
            preNode = preNode.getNext();
        }

        //now the preNode is the last two node, delete the last node
        preNode.setNext(null);
        length--;
    }


    /**
     * find the preNOde
     * @param data data
     * @return preNode
     */
    private Node getPreNode(T data) {
        Node preNode = headNode;
        while (preNode.getNext() != null) {
            if (data.equals(preNode.getNext().getElement())) {
                return preNode;
            }
            preNode = preNode.getNext();
        }
        return null;
    }

    private void printAll() {
        Node node = headNode.getNext();
        if (node != null) {
            System.out.println(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public class Node<T> {
        private T element;
        private Node next;

        public Node(T element) {
            this.element = element;
        }

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
