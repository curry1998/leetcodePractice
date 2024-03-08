package com.boshrong.leetcode.位运算;

public class 不用加减乘除做加法jz65 {
    // 思想: 异或相当于无进位的求和 eg: 1011 + 1001 异或得到 0010 无进位的求和
    // & 相当于求每位的进位， 1 & 1 = 1 进位为1，变为值需要左移一位。
    // 不断重复这个过程，直到进位为0
    public int Add(int num1,int num2) {
        while( num2 != 0){
            int sum = num1 ^ num2;
            num2 = (num2 & num1) << 1;
            num1 = sum;
        }
        return num1;
    }
}
