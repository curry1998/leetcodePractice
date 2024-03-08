package com.boshrong.leetcode.贪心;

public class 整数拆分343 {
    public int integerBreak(int number) {
        if (number == 2) return 1;
        if (number == 3) return 2;
        long cnt = number / 3;
        if (number % 3 == 0) {
            return (int)pow(cnt) ;
        } else if (number % 3 == 1) {
            cnt--;
            return 4 * pow(cnt);
        } else {
            return 2 * pow(cnt) ;
        }
    }
    // 快速幂计算 3的 cnt次
    public int pow (long cnt) {
        // 如何快速计算3的cnt次幂?
        if (cnt == 0) return 1;
        if (cnt == 1) return 3;
        int part = pow(cnt / 2);
        if (cnt % 2 == 0) return part * part ;
        return 3 * part * part;
    }
}
