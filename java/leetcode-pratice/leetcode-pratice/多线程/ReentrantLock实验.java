package com.boshrong.leetcode.多线程;

import jdk.nashorn.internal.ir.CallNode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock实验 {
    private static final Lock lock=new ReentrantLock();
    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            new Thread(()->test(),"Thread"+i).start();
        }

    }
    public static void test()  {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获得了锁");
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e);
        }finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+"释放了了锁");
        }
    }

}
