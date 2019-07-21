package com.llh.hashmap;

/**
 * 自定义hashmap测试类
 */
public class MyMapTest {
    public static void main(String[] args) {
        MyMap map=new MyHashMap();
        map.put("s1",1);
        map.put("s2",2);
        System.out.println("size "+map.size());
        System.out.println("isEmpty "+map.isEmpty());
        System.out.println(map.get("s1"));
    }
}
