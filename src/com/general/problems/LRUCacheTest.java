package com.general.problems;

import org.junit.Test;

public class LRUCacheTest {
    private LRUCacheImpl.LRUCache lruCache = new LRUCacheImpl.LRUCache(4);

    @Test
    public void test1(){
        lruCache.insertKeyValuePair("a", 1);
        lruCache.insertKeyValuePair("b", 2);
        lruCache.insertKeyValuePair("c", 3);
        lruCache.insertKeyValuePair("d", 4);
        System.out.println(lruCache.getValueFromKey("a").value);
        lruCache.insertKeyValuePair("e", 5);
        System.out.println(lruCache.getValueFromKey("a").value);
        System.out.println(lruCache.getValueFromKey("b").value);
        System.out.println(lruCache.getValueFromKey("c").value);
        lruCache.insertKeyValuePair("f", 5);
        System.out.println(lruCache.getValueFromKey("c").value);
        System.out.println(lruCache.getValueFromKey("d").value);
    }
}
