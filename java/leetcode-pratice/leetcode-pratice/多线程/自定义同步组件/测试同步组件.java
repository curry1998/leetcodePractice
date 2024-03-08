package com.boshrong.leetcode.多线程.自定义同步组件;

import org.junit.Test;

import java.util.concurrent.locks.Lock;

public class 测试同步组件 {
    @Test
    public void test() {
        // TwinsLock 实现了Lock接口，并提供面向使用者的接口，使用者调用lock() 方法获取锁。
        // unlock 方法释放锁，同一个线程只有两个线程获取锁。
        //
        final Lock lock = new TwinsLock();
        class Worker extends Thread {

            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
        for(int i = 0; i < 100; i++){
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep(1000);
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
