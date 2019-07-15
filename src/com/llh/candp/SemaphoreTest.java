package com.llh.candp;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * semaphore的使用
 */
public class SemaphoreTest {
    //每组有四个线程同时运行
    public static void main(String[] args) {
        //线程池
        ExecutorService executorService= Executors.newCachedThreadPool();
        //设置信号量同时执行的线程数
        final Semaphore semaphore=new Semaphore(4);
        for (int index=0;index<20;index++){
            final int number=index;
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    try{
                        //获得许可
                        semaphore.acquire();
                        System.out.println("Thread accessing"+number);
                        //睡眠1秒
                        Thread.sleep(1000);
                    }catch (Exception e){

                    }finally {
                        //释放许可
                        semaphore.release();
                    }
                }
            };
            //运行
            executorService.execute(runnable);
        }
        //退出
        executorService.shutdown();
    }
}
