package com.study;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * description
 *
 * @author huanglehao 2020/08/28 10:17
 */
public class LRU<K,V> extends LinkedHashMap<K,V> {
    private final  int MAX_CACHE_SIZE;

    public  LRU(int cacheSize){
        super((int) (Math.ceil(cacheSize / 0.75) + 1), 0.75f, true);
        this.MAX_CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> entry){
        return size() > MAX_CACHE_SIZE;
    }
}
