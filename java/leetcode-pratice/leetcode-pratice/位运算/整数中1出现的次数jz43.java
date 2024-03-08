package com.boshrong.leetcode.位运算;

public class 整数中1出现的次数jz43 {
    public int NumberOf1Between1AndN_Solution(int n) {
        // 从个位数开始
        int base = 1;
        // 总的出现1的次数现在为 0
        int res = 0;
        // 不能超过n
        while(base <= n){
            // 求出当前位 ，高位，低位
            int cur = n/base%10;
            int a = n/base/10;
            int b = n%base;

            // 分三类情况讨论，对应上面解释的三种情况
            if(cur >= 1)
                res += (a+1)*base;
            else if(cur == 0)
                res += a*base;
            else
                res += a*base+b+1;
            base *= 10; // 位数向前移一位
        }
        return res; // 最后得到全部出现1的次数，返回
    }
}
