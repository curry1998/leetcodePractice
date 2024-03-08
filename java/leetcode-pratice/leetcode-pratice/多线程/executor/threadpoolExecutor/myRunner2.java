package com.boshrong.leetcode.多线程.executor.threadpoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class myRunner2 implements Runnable{
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i=0;i<=10;i++){
            Future<?> future = executorService.submit(new myRunner2());
            future.isDone();
        }
        executorService.shutdown();
    }
    @Override
    public void run() {
        for(int i=0;i<=10;i++){
            System.out.printf("currentThread %s and num = %d\n",Thread.currentThread().getName(),i);
        }
    }
}
