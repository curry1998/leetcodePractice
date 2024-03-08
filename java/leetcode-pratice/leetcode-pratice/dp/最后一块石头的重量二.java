package com.boshrong.leetcode.dp;

public class 最后一块石头的重量二 {
    public int lastStoneWeightII(int[] stones) {
        // 尽可能让石头分成重量相同的两堆，相撞之后剩下的石头最小，这样就化解成01背包问题了。
        // 分成两堆石头， 一堆总重量为 dp[target] 另外一堆为 sum - dp[target] 两者相减即可
        int  n = stones.length;
        int target = 0;
        for(int i = 0; i < n; i++){
            target += stones[i];
        }
        int sum = target;
        target = target / 2;
        int [] dp = new int [target + 1];
        for(int i = 0; i < n; i++ ){
            for(int j = target; j > 0 ; j--){
                if(j >= stones[i])
                    dp[j] = Math.max(dp[j],dp[j - stones[i]] + stones[i]);
            }
        }
        //打印dp 数组
        for(int i = 0; i < n; i++){
            System.out.printf("%d ", dp[i]);
        }
        return sum - dp[target] - dp[target];
    }
}
