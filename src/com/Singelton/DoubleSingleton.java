package com.Singelton;

/**
 * 双重检索方式实现单例模式
 */
public class DoubleSingleton {
    //保证该类唯一的实例，用volatile修饰确保多线程下的可见性和有序性
    private static volatile DoubleSingleton instance=null;
    //私有构造函数确保其他类无法通过new的方式创建该类的实例
    private DoubleSingleton(){}
    //提供公有的静态方法共外部调用
    public static DoubleSingleton getInstance(){
        if (instance==null){
            synchronized (DoubleSingleton.class){
                if (instance==null){
                    instance=new DoubleSingleton();
                }
            }
        }
        return instance;
    }
}
