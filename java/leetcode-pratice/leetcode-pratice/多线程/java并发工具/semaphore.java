package com.boshrong.leetcode.多线程.java并发工具;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class semaphore {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
    // 最大并发数为10
    private static  Semaphore s= new Semaphore(10);
    public static void main(String[] args) {
        for(int i=0;i<THREAD_COUNT;i++){
            int finalI = i;
            executorService.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    s.acquire();
                    System.out.println("save data"+ finalI);
                    s.release();
                }
            });
        }
        executorService.shutdown();
    }
}
