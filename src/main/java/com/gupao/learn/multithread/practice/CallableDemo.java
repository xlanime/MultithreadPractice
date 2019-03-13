package com.gupao.learn.multithread.practice;

import java.util.concurrent.*;

/**
 * Description:使用Callable/future实现多线程访问
 *
 * @author 轩辚
 * @date 2019/3/13 18:00
 */
public class CallableDemo implements Callable<CallableBean> {

    /**
     * 调用CallableDemo
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CallableDemo callableDemo = new CallableDemo();
        Future<CallableBean> future = executorService.submit(callableDemo);
        try {
            //future.get这个操作是阻塞的
            System.out.println(future.get().getUsername());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    @Override
    public CallableBean call() throws Exception {
        return new CallableBean();
    }
}
