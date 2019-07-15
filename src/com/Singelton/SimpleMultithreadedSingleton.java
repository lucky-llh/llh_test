package com.Singelton;

/**
 * 简单加锁实现单例模式
 */
public class SimpleMultithreadedSingleton {
    //保证该类的唯一实例
    private static SimpleMultithreadedSingleton instance=null;
    //私有构造函数确保其他类无法直接通过new创建该类的实例
    private SimpleMultithreadedSingleton(){
    }
    public static SimpleMultithreadedSingleton getInstance(){
        synchronized (SimpleMultithreadedSingleton.class){
            if (instance==null){
                instance=new SimpleMultithreadedSingleton();
            }
        }
        return instance;
    }

}
