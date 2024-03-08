package com.boshrong.leetcode.位运算;

public class 不用加减乘除做加法leetcode {
    public int add(int a, int b) {
        return b == 0 ? a : add(a ^ b , (a & b) << 1);
    }
}
