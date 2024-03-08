package com.boshrong.leetcode.哈希;

import java.util.HashSet;

public class 快乐数 {

    public boolean isHappy(int n) {
        // 如果一个数重复出现，则不是快乐数
        HashSet<Integer> set= new HashSet<>();
        while(n !=1){
            n = getPow(n);
            if(set.contains(n)){
                return false;
            }
            set.add(n);
        }
        return true;
    }
    public int getPow(int num){
        int res =0;
        while(num!=0){
            int n =num%10;
            res += n*n;
            num/=10;
        }
        return res;
    }
}
