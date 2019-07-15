package com.llh.candp;

/**
 * 测试主类
 */
public class ProducerAndConsumerByCondition {
    public static void main(String[] args) {
        ResourceByCondition condition=new ResourceByCondition();
        Producer producer=new Producer(condition);
        Consumer consumer=new Consumer(condition);
        //生产者线程
        Thread producer1=new Thread(producer);
        Thread producer2=new Thread(producer);
        //消费者线程
        Thread consumer1=new Thread(consumer);
        Thread consumer2=new Thread(consumer);
        //启动线程
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
