package com.krishna.app.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheWithLinkedHashMap {
    LinkedHashMap<Integer, String> linkedHashMap = null;
    private final int CAPACITY;

    public LRUCacheWithLinkedHashMap(int CAPACITY) {
        this.CAPACITY = CAPACITY;
        //accessOrder : true for  access-order, false for insertion-order
        linkedHashMap = new LinkedHashMap<Integer, String>(CAPACITY, 0.75f, true) {
            protected  boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public void set(int key, String value) {
        linkedHashMap.put(key, value);
    }

    public String get(int key) {
        return linkedHashMap.getOrDefault(key, "None");
    }
}
