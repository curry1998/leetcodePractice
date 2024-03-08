package com.boshrong.leetcode.dp;

public class 戳气球 {
    public static void main(String[] args) {
        int [] nums = new int[]{3,1,5,8};
        maxCoins(nums);
    }
    public static int maxCoins(int[] nums) {
        // dp[i][j] 把k 当作最后一个点爆
        // dp[i] [j] 表示 从第i 个气球到第j 个气球(闭空间)能够获取硬币的最大值。
        // 则 dp[i][j] = dp[i][k-1] + dp[k+1][j] + nums[i-1]*nums[k] * nums[j+1] (i<k<j) j大于i。
        // 状态转移方程: dp[i][j]=Math.max(dp[i][k]+dp[k+1][j]+ res[i]*res[k]*res[j],dp[i][j]); res是插入了两个1的数组
        int lens = nums.length;
        //重新定义一个nums 数组，为res
        int [] res = new int [lens+2];
        for(int i = 0;i < lens+2;i++){
            if(i == 0|| i == lens+1){
                res[i] = 1;
                continue;
            }
            res[i] = nums[i-1];
        }

        //为了操作方便，可以在nums 左右两边添加虚拟的气球。
        int [][] dp = new int[lens+2][lens+2];

        for(int i= lens + 1;i >= 0;i--){
            for(int j = i+1;j < lens+2;j++){
                for(int k= i+1; k < j;k++){
                    //res[i] res[j] 还没有戳
                    dp[i][j] = Math.max(dp[i][k]+dp[k][j]+res[i]*res[k]*res[j],dp[i][j]);
                }
            }
        }
        return dp[0][lens+1];
    }
}
