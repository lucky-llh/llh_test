package com.llh.candp;

/**
 * 使用synchronized实现生产者消费者
 */
public class ResourceBySynchronized {
    private String name;
    private int count=1;
    private boolean flag;
    public synchronized void producer(String name){
        while (flag){
            try{
                this.wait();
            }catch (Exception e){

            }
        }
        this.name=name+count;
        count++;
        System.out.println(Thread.currentThread().getName()+"——synchronized生产者——"+this.name);
        flag=true;
        //通知消费者线程（但有可能导致消费者被唤醒，因为他们公用同一个队列）
        this.notifyAll();
    }
    public synchronized void consumer(){
        while (!flag){
            try{
                this.wait();
            }catch (Exception e){

            }
        }
        System.out.println(Thread.currentThread().getName()+"——synchronized消费者——"+this.name);
        flag=false;
        //通知生产者线程
        this.notifyAll();
    }
}
