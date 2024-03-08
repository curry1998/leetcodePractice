package com.boshrong.leetcode.dp;

import java.util.Arrays;

public class 零钱兑换二回溯 {

    int ans = 0;
    public int change(int amount, int[] coins) {
        // 思路:  回溯解决， 或者完全背包, 超时
        // 可以无限取
        Arrays.sort(coins);
        dfs(amount, coins,0);

        return ans;
    }
    public void dfs(int num, int [] coins,int startIndex){
        if(num<0){
            return;
        }
        if(num==0){
            ans++;
            return;
        }
        for(int i=startIndex;i<coins.length;i++){
            if(num<coins[i]){
                return;
            }
            dfs(num-coins[i],coins,i);//重复选
        }
    }
}
