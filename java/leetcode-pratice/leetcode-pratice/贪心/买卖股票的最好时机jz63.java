package com.boshrong.leetcode.贪心;

public class 买卖股票的最好时机jz63 {


    public int maxProfit (int[] prices) {
        // 用两个变量 一个记录该日之前股票最低的价格， 一个用于记录当前的最大收益。 遍历一遍就可以了

        int lens=prices.length;
        if(lens<2){
            return 0;
        }
        int proMin=prices[0];
        int currentMax=Integer.MIN_VALUE;
        for(int i=1;i<lens;i++){

            int val=prices[i]-proMin;
            if(val>currentMax){
                currentMax=val;
            }

            if(prices[i]<proMin){
                proMin=prices[i];
            }
        }
        if (currentMax<=0){
            return 0;
        }else {
            return currentMax;
        }
    }

}
