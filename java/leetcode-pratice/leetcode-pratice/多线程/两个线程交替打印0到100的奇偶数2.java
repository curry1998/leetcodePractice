package com.boshrong.leetcode.多线程;

public class 两个线程交替打印0到100的奇偶数2 {

    private static int count=0;
    private static Object lock=new Object();
    public static void main(String[] args) {
        Thread odd = new Thread(() -> {
            while(count<=100){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+":"+count++);
                    lock.notifyAll();
                    try {
                        // 进行休眠，不争夺锁,等到另一个线程的唤醒
                        if(count<=100)
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "偶数");
        Thread even = new Thread(() -> {
            while(count<=100){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+":"+count++);
                    lock.notifyAll();
                    try {
                        // 没有if 判断语句就会,就会一个线程一直阻塞
                        if(count<=100)
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }, "奇数");
        odd.start();
        even.start();
    }
}
