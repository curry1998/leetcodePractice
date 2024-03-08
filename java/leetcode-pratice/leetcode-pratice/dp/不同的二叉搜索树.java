package com.boshrong.leetcode.dp;

public class 不同的二叉搜索树 {
    public int numTrees(int n) {
        // dp[i] 从1 到i 互不相同的二叉搜索树个数,枚举1 到i，i个节点作为根节点的二叉树个数累加
        // dp[i]=(求和 j从1到i) dp(j-1) * dp(i-j);构造数量只与节点数有关。
        int [] dp = new int[n+1];
        dp[0] =1; // 要乘dp[0]=1
        for(int i=1;i<=n;i++){
            // 以j 为根节点， j 从1 到i， 因此 dp[i] 是加
            // * 是因为 左子树一个不同，就会产生和右子树全部不同的结果。
            for(int j=1;j<=i;j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
