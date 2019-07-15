package com.Singelton;

/**
 * 静态内部类实现单例模式:
 *
 */
public class StaticHolderSingleton {
    private StaticHolderSingleton(){}

    private static class InstanceHolder{
        final static StaticHolderSingleton INSTANCE=new StaticHolderSingleton();
    }
    public static StaticHolderSingleton getInstance(){
        return InstanceHolder.INSTANCE;
    }
    public void someService(){

    }

    public static void main(String[] args) {
        //当调用getInstance方法时，jvm会初始化这个方法内部访问的静态内部类InstanceHolder.然后该类的INSTANCE静态变量就会被初始化，
        // 从而使得StaticHolderSingleton类的唯一实例被创建
        StaticHolderSingleton.getInstance().someService();
    }
}
