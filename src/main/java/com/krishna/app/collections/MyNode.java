package com.krishna.app.collections;

public class MyNode<K,V> {
    K key;
    V value;
    MyNode prev;
    MyNode next;
    public MyNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
