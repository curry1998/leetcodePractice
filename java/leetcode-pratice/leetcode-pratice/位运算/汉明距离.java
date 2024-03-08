package com.boshrong.leetcode.位运算;

public class 汉明距离 {
    public int hammingDistance(int x, int y) {
        // 思路, 按位异或得到一个数，判断这个数的各个位，如果为1，则进行累加
        // 位运算
        int count=0;
        x^=y;
        while(x!=0){
            //判断最低位是否为1
            if(x%2==1){
                count++;
            }
            x=x>>1;
        }

        return count;
    }
}
