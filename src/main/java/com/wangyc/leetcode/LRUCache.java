package com.wangyc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 146, LURCache
 *
 * @author wangyc
 */
public class LRUCache {

    Map<Integer, Node> map;
    DLinkedList cache;
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DLinkedList();
        cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            int value = map.get(key).val;
            put(key, value);
            return value;
        }
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (map.containsKey(key)) {
            cache.delete(map.get(key));
            cache.addFirst(newNode);
            map.put(key, newNode);
        } else {
            if (map.size() == cap) {
                int k = cache.deleteLast();
                map.remove(k);
            }
            cache.addFirst(newNode);
            map.put(key, newNode);
        }
    }

    class DLinkedList {
        Node head;
        Node tail;

        public DLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        public void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }

        public int delete(Node node) {
            int key = node.key;

            node.next.prev = node.prev;
            node.prev.next = node.next;

            return key;
        }

        public int deleteLast() {
            if (head.next == tail) {
                return -1;
            }
            return delete(tail.prev);
        }
    }

    class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
