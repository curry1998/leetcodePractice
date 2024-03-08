package com.boshrong.leetcode.多线程.java并发工具;

import java.util.concurrent.CountDownLatch;

public class countDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch= new CountDownLatch(2);
        new Thread(()->{
            System.out.println(2);
            for(int i=0;i<100000;i++){

            }
            System.out.println(4);
            countDownLatch.countDown();
        }).start();
        new Thread(()->{
            System.out.println(1);
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        System.out.println(3);
    }
}
