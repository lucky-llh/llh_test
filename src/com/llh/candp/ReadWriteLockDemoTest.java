package com.llh.candp;

public class ReadWriteLockDemoTest {
    public static void main(String[] args) {
        ResourceByReadAndWriteLock lock=new ResourceByReadAndWriteLock();
        //定义十个读线程
        for (int i=0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.readNum();
                }
            }).start();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.writeNum((int)(Math.random()*101));
            }
        },"write").start();
    }
}
