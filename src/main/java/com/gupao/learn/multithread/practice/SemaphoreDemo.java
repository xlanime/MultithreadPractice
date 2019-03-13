package com.gupao.learn.multithread.practice;

import java.util.concurrent.Semaphore;

/**
 * Description:信号灯demo
 *
 * @author 轩辚
 * @date 2019/3/14 0:56
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i=0;i<10;i++){
            new DoAnything(i,semaphore).start();
        }
    }

    /**
     * 测试线程类
     */
    private static class DoAnything extends Thread{
        private int num;
        private Semaphore semaphore;

        public DoAnything(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                //申请获取到令牌
                semaphore.acquire();
                System.out.println("第"+num+"个线程获取到令牌");
                Thread.sleep(2000);
                //归还令牌
                semaphore.release();
                System.out.println("第"+num+"个线程归还令牌");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

