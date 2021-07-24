package com.krishna.app.collections;

import java.util.HashMap;

public class LRUCacheWithDoubleLinkedList {

    private HashMap<Integer, DoubleNode<Integer, String>> myNodeHashMap = null;
    private int capacity, count;
    private DoubleNode<Integer, String> head, tail;

    public LRUCacheWithDoubleLinkedList(int capacity) {
        this.capacity = capacity;
        myNodeHashMap = new HashMap<>();
        head = new DoubleNode<Integer, String>(0, null);
        tail = new DoubleNode<Integer, String>(0, null);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
    }

    public void deleteNode(DoubleNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(DoubleNode node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public String get(int key) {
        if (myNodeHashMap.get(key) != null) {
            DoubleNode<Integer, String> myNode = myNodeHashMap.get(key);
            String result = myNode.value;
            deleteNode(myNode);
            addToHead(myNode);
            return result;
        }
        return null;
    }

    public void set(int key, String value) {
        if (myNodeHashMap.get(key) != null) {
            DoubleNode<Integer, String> myNode = myNodeHashMap.get(key);
            myNode.value = value;
        } else {
            DoubleNode<Integer, String> myNode = new DoubleNode<>(key, value);
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

    public static void main(String[] args) {
        LRUCacheWithDoubleLinkedList lruCache = new LRUCacheWithDoubleLinkedList(3);
        lruCache.set(1, "Krishna");
        lruCache.set(2, "Krishna");
        lruCache.set(3, "Krishna");
        lruCache.get(1);
        lruCache.set(4, "Krishna"); //instead of 1, 2 should be evicted.
        lruCache.get(1);
        lruCache.get(2);//Fails
    }
}
