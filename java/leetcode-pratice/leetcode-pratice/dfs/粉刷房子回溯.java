package com.boshrong.leetcode.dfs;

public class 粉刷房子回溯 {
    // 回溯是超时的，其递归的深度随着房子在不断的增加。
    int ans = Integer.MAX_VALUE;
    public int minCost(int[][] costs) {
        // dfs 解题
        dfs(costs,-1,-1,0);
        return ans;
    }
    public void dfs(int [][] costs, int x, int y, int count){
        x++;
        if(x == costs.length){
            if(count < ans){
                ans = count;
            }
            return;
        }
        for(int i = 0; i < 3; i++){
            if(y != -1 &&  y == i){
                continue;
            }
            count += costs[x][i];
            dfs(costs,x,i,count);
            count -= costs[x][i];
        }
    }
}
