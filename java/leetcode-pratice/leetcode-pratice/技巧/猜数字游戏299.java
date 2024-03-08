package com.boshrong.leetcode.技巧;

public class 猜数字游戏299 {
    public String getHint(String secret, String guess) {
        // 统计每一个数字在两个数组中出现次数的最小值，统计位置相同的 A，用最小值减去A 就是B
        // a: 数字相同，位置也相同 (所有) b 数字相同，位置不同。
        int lens=guess.length();
        int [] valueA=new int[10];
        int [] valueB=new int[10];
        int a=0,b=0;
        for(int i=0;i<lens;i++){
            int x=secret.charAt(i)-'0';
            int y=guess.charAt(i)-'0';
            if(x==y) a++; //数字相同位置相同
            // 统计每个字符出现在A，B 中出现次数
            valueA[x]++;
            valueB[y]++;
        }
        for(int i=0;i<10;i++)
            b+=Math.min(valueA[i],valueB[i]); //有多少个同时都有
        b=b-a;
        return a+"A"+b+"B";


    }
}
