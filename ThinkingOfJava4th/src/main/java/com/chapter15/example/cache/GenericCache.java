package com.chapter15.example.cache;

import java.util.HashMap;
import java.util.Map;

public class GenericCache<K, V> {
    private Map<K, V> cache = new HashMap<>();

    // 添加
    public void put(K key, V value) {
        cache.put(key, value);
    }

    // 获取
    public V get(K key) {
        return cache.get(key);
    }

    // 删除
    public void remove(K key) {
        cache.remove(key);
    }

    // 清除
    public void clear() {
        cache.clear();
    }
}
