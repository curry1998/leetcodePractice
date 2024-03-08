package com.boshrong.leetcode.多线程;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntgerTest {
    static AtomicInteger ai = new AtomicInteger(5);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.decrementAndGet());
        System.out.println(ai.compareAndSet(5,6));
        System.out.println(ai.compareAndSet(5,4));

    }
}
