package com.boshrong.leetcode.贪心;

public class 剪绳子进阶版jz14贪心做法 {
    public int cuttingRope(int n) {
        // m>1 必须要剪一段 小于4 要特殊判断
        // 当n>=5的时候，尽可能剪长度为3的绳子,当剩下的绳子长度为4，则将绳子剪成长度为2的绳子。
        if(n<4){
            return n-1;
        }


        long res = 1;
        while(n > 4){
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        return (int)(res * n % 1000000007);
    }
}
