package com.boshrong.leetcode.多线程.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class myRunner implements Runnable{
    public static void main(String[] args) {
        // 一个任务建立一个线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            executorService.execute(new myRunner());
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

