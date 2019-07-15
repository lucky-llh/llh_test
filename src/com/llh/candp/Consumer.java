package com.llh.candp;

/**
 * 消费者线程
 */
public class Consumer implements Runnable{

    private ResourceByCondition condition;
    public Consumer(ResourceByCondition condition){
        this.condition=condition;
    }
    @Override
    public void run() {
        while (true){
            condition.consumer();
        }
    }
}
