package com.boshrong.leetcode.多线程.等待通知;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionUseCase {
    private Lock lock;
    private Condition condition;
    public ConditionUseCase(){
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

//    public static void main(String[] args) throws InterruptedException {
//        ConditionUseCase useCase = new ConditionUseCase();
//        new Thread(()->{
//            try {
//                useCase.conditionWait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(()->{
//            try {
//                useCase.conditionSingle();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        Thread.sleep(1000);
//
//    }
    public void conditionWait() throws InterruptedException{
        lock.lock();
        try{
            System.out.println(Thread.currentThread());
            // await 的时候会释放锁
            condition.await();
        }finally {
            lock.unlock();
        }
    }

    public void conditionSingle() throws InterruptedException{
        lock.lock();
        try{
            condition.signal();
        }finally {
            lock.unlock();
        }
    }
}
