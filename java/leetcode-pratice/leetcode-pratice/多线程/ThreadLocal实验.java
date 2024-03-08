package com.boshrong.leetcode.多线程;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.util.unit.DataUnit;

import java.text.SimpleDateFormat;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocal实验 {

    static ThreadLocal<Integer> threadlocal = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println(threadlocal.get());
            threadlocal.set(1);
            System.out.println(threadlocal.get());
        },"t1");

        Thread t2 = new Thread(() -> {
            System.out.println(threadlocal.get());
            threadlocal.set(2);
            System.out.println(threadlocal.get());
        },"t2");
        t1.start();
        // 等待t1执行完毕
        t1.join();
        t2.start();
    }
}

