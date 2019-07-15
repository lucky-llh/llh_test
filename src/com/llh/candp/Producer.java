package com.llh.candp;

/**
 * 生产者线程
 */
public class Producer implements Runnable {
    private ResourceByCondition condition;
    public Producer(ResourceByCondition condition){
        this.condition=condition;
    }
    @Override
    public void run() {
        while (true){
            condition.product("烤鸭");
        }
    }
}
