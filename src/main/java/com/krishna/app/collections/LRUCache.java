package com.krishna.app.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRUCache {

    private HashMap<Integer, MyNode<Integer, String>> myNodeHashMap = null;
    private int capacity, count;
    private MyNode<Integer, String> head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        myNodeHashMap = new HashMap<>();
        head = new MyNode<Integer, String>(0, null);
        tail = new MyNode<Integer, String>(0, null);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
    }

    public void deleteNode(MyNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(MyNode node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public String get(int key) {
        if (myNodeHashMap.get(key) != null) {
            MyNode<Integer, String> myNode = myNodeHashMap.get(key);
            String result = myNode.value;
            deleteNode(myNode);
            addToHead(myNode);
            return result;
        }
        return null;
    }

    public void set(int key, String value) {
        if (myNodeHashMap.get(key) != null) {
            MyNode<Integer, String> myNode = myNodeHashMap.get(key);
            myNode.value = value;
        } else {
            MyNode<Integer, String> myNode = new MyNode<>(key, value);
            myNodeHashMap.put(key, myNode);
            if (count < capacity) {
                count++;
                addToHead(myNode);
            } else {
                myNodeHashMap.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(myNode);
            }
        }
    }
}
