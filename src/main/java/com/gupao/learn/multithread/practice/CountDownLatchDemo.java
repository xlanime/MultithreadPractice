package com.gupao.learn.multithread.practice;

import java.util.concurrent.CountDownLatch;

/**
 * Description:CountDownLatchDemo
 *
 * @author 轩辚
 * @date 2019/3/13 22:34
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        //初始化CountDownLatch并声明计数器的大小为3
        CountDownLatch countDownLatch = new CountDownLatch(4);
        new Thread(()->{
            //countDown的造作是完成原子性的递减操作（线程安全）
            countDownLatch.countDown();
        }).start();
        new Thread(()->{
            countDownLatch.countDown();
        }).start();
        new Thread(()->{
            countDownLatch.countDown();
        }).start();
        //await阻塞，释放的条件是计数器为0的时候
        //await获取到的是共享锁
        countDownLatch.await();
        System.out.println("执行完毕");
    }
}
