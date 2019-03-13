package com.gupao.learn.multithread.practice;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author 轩辚
 * @date 2019/3/13 19:15
 */
public class InterruptDemo {

    private static int i;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){
                i++;
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Tread is interrupted - before interrupt "+i+":"+thread.isInterrupted());
        thread.interrupt();
        System.out.println("Tread is interrupted - after interrupt "+i+":"+thread.isInterrupted());
    }
}
