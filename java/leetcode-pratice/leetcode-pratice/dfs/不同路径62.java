package com.boshrong.leetcode.dfs;

public class 不同路径62 {
    // 深度优先搜索时间超时

    int m;
    int n;
    int res;
    int [] dx=new int[]{1,0};
    int [] dy=new int[]{0,1};
    public int uniquePaths(int m, int n) {
        this.m=m;
        this.n=n;
        this.res=0;
        dfs(1,1);
        return this.res;
    }
    public void dfs(int x,int y){
        if(x==m && n==y){
            this.res++;
        }
        for(int i=0;i<2;i++){
            int ix=x+dx[i];
            int iy=x+dy[i];
            if(ix>=1&&ix<=m && iy>=1&&iy<=n){
                dfs(ix,iy);
            }
        }
    }
}
