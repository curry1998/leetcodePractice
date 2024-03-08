package com.boshrong.leetcode.位运算;

public class 二进制中1的个数jz15 {
    // 与1 & 可以获得个位是否为1，再无符号左移一位。
    public int NumberOf1(int n) {
        int res=0;

        while(n!=0){
            res += n&1;
            n=n>>>1;
        }
        return res;
    }
}
