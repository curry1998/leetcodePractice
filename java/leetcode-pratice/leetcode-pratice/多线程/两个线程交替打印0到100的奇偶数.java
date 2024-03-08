package com.boshrong.leetcode.多线程;

public class 两个线程交替打印0到100的奇偶数 {
    private static int count = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        turning();
    }

    public static void turning() {
        Thread even = new Thread(() -> {
            while (count < 100) {
                synchronized (lock) {
                    // 只处理偶数
                    if ((count & 1) == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + count++);
                    }
                }
                // 下面判断for 循环就会释放锁锁
            }
        }, "偶数");
        Thread odd = new Thread(() -> {
            while (count < 100) {
                synchronized (lock) {
                    // 只处理奇数
                    if ((count & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + ": " + count++);
                    }
                }
            }
        }, "奇数");
        even.start();
        odd.start();
    }

}
