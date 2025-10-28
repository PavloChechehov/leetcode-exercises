package com.paul;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implementation <a href="https://leetcode.com/problems/lru-cache/description/">Leetcode LRU cache problem</a>
 * using the java LinkedHashMap
 * Very simple solution.
 */
public class LRUCacheV2 extends LinkedHashMap<Integer, Integer> {

    private final int capacity;
    public LRUCacheV2(int capacity) {
        super(capacity, 0.75f, true); // true = access order
        this.capacity = capacity;
    }

    int get(int key) {
        Integer val = super.get(key);
        if (val == null) {
            return -1;
        }

        return val;
    }

    /*
    * Evict oldest when size exceeds capacity
    * */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

}
