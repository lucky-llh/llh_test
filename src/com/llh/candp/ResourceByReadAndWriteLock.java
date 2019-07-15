package com.llh.candp;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁demo
 */
public class ResourceByReadAndWriteLock {
    //共享数据
    private int num=0;
    //读写锁
    private ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    public void readNum(){
        try {
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName()+"——读线程——"+num);
        }finally {
            readWriteLock.readLock().unlock();
        }
    }
    public void writeNum(int num){
        try{
            readWriteLock.writeLock().lock();
            this.num=num;
            System.out.println(Thread.currentThread().getName()+"——写线程——"+num);
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
