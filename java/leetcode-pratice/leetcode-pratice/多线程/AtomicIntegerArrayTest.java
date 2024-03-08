package com.boshrong.leetcode.多线程;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {
    static int [] value = new int[]{1,5,6,7,3};

    static AtomicIntegerArray aia = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        aia.getAndSet(0,3);
        System.out.println(aia.get(0));
        System.out.println(value[0]);
    }
}
