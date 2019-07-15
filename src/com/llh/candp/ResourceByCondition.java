package com.llh.candp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 基于Condition实现消费者生产者模式
 */
public class ResourceByCondition {

    //商品名
    private String name;
    //数量
    private int count;
    //标志位 当flag=true时，说明有商品，生产者等待，否则消费者等待
    private boolean flag;

    private Lock lock=new ReentrantLock();
    //生产者队列
    private Condition pro_condition=lock.newCondition();
    //消费者队列
    private Condition cons_condition=lock.newCondition();

    /**
     * 生产者生产产品
     * @param name
     */
    public void product(String name){
        try{
            lock.lock();
            //有商品时，生产者等待
            while (flag){
                try{
                    pro_condition.await();
                }catch (Exception e){
                }
            }
            //否则，生产商品
            this.name=name+count;
            count++;
            System.out.println(Thread.currentThread().getName()+"——生产者——"+this.name);
            flag=true;
            //唤醒消费者线程
            cons_condition.signal();
        }finally {
            lock.unlock();
        }
    }
    public void consumer(){
        try{
            lock.lock();
            while (!flag){
                try {
                    cons_condition.await();
                }catch (Exception e){

                }
            }
            System.out.println(Thread.currentThread().getName()+"——消费者——"+this.name);
            flag=false;
            //通知消费者线程生产
            pro_condition.signal();
        }finally {
            lock.unlock();
        }
    }


}
