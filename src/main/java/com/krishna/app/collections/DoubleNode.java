package com.krishna.app.collections;

public class DoubleNode<K,V> {
    K key;
    V value;
    DoubleNode prev;
    DoubleNode next;
    public DoubleNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
