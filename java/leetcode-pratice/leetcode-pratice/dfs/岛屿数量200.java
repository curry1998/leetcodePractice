package com.boshrong.leetcode.dfs;

public class 岛屿数量200 {
    //定义四个方向 上下左右
    int [] dx=new int[]{-1,0,1,0};
    int [] dy=new int[]{0,1,0,-1};

    //上下左右 全为0 返回false，有1 进入搜索,dfs搜索的目的就是对flag 数组进行标记。
    public void dfs(char [][] grid,boolean [][] flag,int i,int j){
        int len1=grid.length;
        int len2=grid[0].length;
        if(grid[i][j]==0){
            return ;
        }

        for(int k=0;k<4;k++){
            if(i+dx[k]<len1&& i+dx[k]>=0 && j+dy[k]>=0&& j+dy[k]<len2){
                if(grid[i+dx[k]][j+dy[k]]=='1'&& flag[i+dx[k]][j+dy[k]]==false){
                    flag[i+dx[k]][j+dy[k]]=true;
                    dfs(grid,flag,i+dx[k],j+dy[k]);

                }
            }
        }

    }
    public int numIslands(char[][] grid) {
        int len1=grid.length;
        int len2=grid[0].length;
        if(len1==0 && len2==0){
            return 0;
        }
        int result=0;
        boolean [][] flag=new boolean[len1][len2];
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                if(grid[i][j]=='1'&& flag[i][j]==false){
                    flag[i][j]=true;
                    dfs(grid,flag,i,j);
                    result++;
                }
            }
        }

        return result;
    }
}
