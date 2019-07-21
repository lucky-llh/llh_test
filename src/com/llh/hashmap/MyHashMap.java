package com.llh.hashmap;

import java.util.Set;

/**
 * 自定义hashmap：数组+链表
 */
public class MyHashMap<K,V> implements MyMap{
    //默认容量
    private final int DEFAULT_CAPACITY=16;
    //内部存储结构
    Node[]table=new Node[DEFAULT_CAPACITY];
    //长度
    private int size=0;
    Set<K> keySet;

    /**
     *获取元素个数
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * 是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * 获取数据
     * @param key
     * @return
     */
    @Override
    public Object get(Object key) {
        //计算key的hash
        int hash=hash(key);
        //计算在数组中的位置
        int i=indexFor(hash,table.length);
        for(Node node=table[i];node!=null;node=node.next){
            if(node.key.equals(key)&&hash==node.hash){
                return node.value;
            }
        }
        return null;
    }

    /**
     * 存放元素
     * @param key
     * @param value
     * @return
     */
    @Override
    public Object put(Object key, Object value) {
        //计算hash值
        int hash=hash(key);
        //找到存放的位置
        int i=indexFor(hash,table.length);
        //i位置已经有数据
        for(Node node=table[i];node!=null;node=node.next){
            Object k;
            //数组中有这个key，就进行覆盖
            if(node.hash==hash&&((k=node.key)==key||key.equals(k))){
                Object oldValue=node.value;
                node.value=value;
                return oldValue;
            }
        }
        //如果i位置没有数据，
        addEntry(key,value,hash,i);
        return null;
    }
    public void addEntry(Object key,Object value,int hash,int index){
        //如果超过原数组大小，则扩大数组
        if(++size==table.length){
            Node[]newTable=new Node[table.length*2];
            System.arraycopy(table,0,newTable,0,table.length);
            table=newTable;
        }
        Node eNode=table[index];
        //新增一个结点，将结点的next指向前一个结点
        table[index]=new Node(hash,key,value,eNode);

    }
    public int indexFor(int hash,int tablen){
        return hash%tablen;
    }
    public int hash(Object key){
        return key==null?0:key.hashCode()^(key.hashCode()>>>16);
    }

    /**
     * 定义静态内部类Node
     */
    static class Node implements MyMap.Entry{
        int hash;
        Object key;
        Object value;
        Node next;
        Node(int hash,Object key,Object value,Node next){
            this.hash=hash;
            this.key=key;
            this.value=value;
            this.next=next;
        }
        @Override
        public Object getKey() {
            return this.key;
        }

        @Override
        public Object getValue() {
            return this.value;
        }
    }
}
