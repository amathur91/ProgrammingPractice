package com.general.problems;

import java.util.HashMap;

public class LRUCacheImpl {
    static class LRUCache {
        int maxSize;
        HashMap<String, CacheData> cacheMap = new HashMap<>();
        CacheData start = null;
        int cacheDataSize = 0;
        CacheData end = null;
        public LRUCache(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
        }

        public void insertKeyValuePair(String key, int value) {
            if(cacheMap.containsKey(key)){
                cacheMap.get(key).setData(value);
                //CacheData Node should be moved to the top
                moveCacheDataToFirst(cacheMap.get(key));
            }else{
                CacheData cacheData = new CacheData(value);
                cacheData.setKey(key);
                cacheMap.put(key, cacheData);
                checkAndAddToCacheList(cacheData);
            }

        }

        private void checkAndAddToCacheList(CacheData cacheData) {
            if(cacheDataSize < maxSize){
                if(cacheDataSize == 0){
                    end = cacheData;
                }
                cacheData.setNext(start);
                start = cacheData;
                if(cacheData.getNext() != null) {
                    cacheData.getNext().setPrevious(cacheData);
                }
                cacheDataSize++;
            }else{//evict something
                cacheData.setNext(start);
                start = cacheData;
                cacheData.getNext().setPrevious(cacheData);

                //evict
                CacheData lastNode = end;
                if(lastNode != null) {
                    if(end.getPrevious() != null){
                        end = end.getPrevious(); //last entry is no more referenced
                        end.setNext(null);
                    }else if(maxSize == 1){
                        end = start;
                    }
                    lastNode.setPrevious(null);
                    lastNode.setNext(null);
                    lastNode.setData(0);
                    cacheMap.remove(lastNode.getKey());
                }
            }
        }

        private void moveCacheDataToFirst(CacheData cacheData) {
            if(start != cacheData &&  maxSize > 1) {
                if(cacheData == end){
                    end = end.getPrevious();
                }
                if(cacheData.getPrevious() != null) {
                    cacheData.getPrevious().setNext(cacheData.getNext());
                }
                if(cacheData.getNext() != null) {
                    cacheData.getNext().setPrevious(cacheData.getPrevious());
                }
                cacheData.setPrevious(null);
                cacheData.setNext(start);
                start = cacheData;
                cacheData.getNext().setPrevious(cacheData);
            }
        }

        public LRUResult getValueFromKey(String key) {
            if(cacheMap.containsKey(key)){
                moveCacheDataToFirst(cacheMap.get(key));
                return new LRUResult(true, cacheMap.get(key).getData());
            }else{
                return new LRUResult(false, 0);
            }
        }

        public String getMostRecentKey() {
           return start.getKey();
        }
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }
}

class CacheData{
    private String key;
    private int data;
    private CacheData previous;
    private CacheData next;

    public CacheData(int data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public CacheData getPrevious() {
        return previous;
    }

    public void setPrevious(CacheData previous) {
        this.previous = previous;
    }

    public CacheData getNext() {
        return next;
    }

    public void setNext(CacheData next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
