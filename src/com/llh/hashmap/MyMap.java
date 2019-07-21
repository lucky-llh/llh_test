package com.llh.hashmap;

/**
 * 自定义实现map接口
 * @param <K>
 * @param <V>
 */
public interface MyMap<K,V> {
    int size();
    boolean isEmpty();
    Object get(Object key);
    Object put(Object key,Object value);
    interface Entry<k,v>{
        k getKey();
        v getValue();
    }
}
