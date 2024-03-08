package com.boshrong.leetcode.dfs;

public class 省份数量 {
    int [] dx=new int[]{0,1,0,-1};
    int [] dy=new int[]{-1,0,1,0};
    int rowLens;
    int colLens;
    public int findCircleNum(int[][] isConnected) {
        rowLens=isConnected.length;
        colLens=isConnected[0].length;

        int res=0;
        for(int i=0;i<rowLens;i++){
            for(int j=0;j<colLens;j++){
                if(isConnected[i][j]==1){
                    dfs(isConnected,i,j);
                    res++;

                }
            }
        }
        return res;

    }
    public void dfs(int [][] isConnected,int i,int j){

        isConnected[i][j]=0;
        for(int k=0;k<4;k++){
            int i_dx=i+dx[k];
            int j_dy=j+dy[k];
            if(i_dx>=0 && i_dx<rowLens&& j_dy>=0&& j_dy<colLens&& isConnected[i_dx][j_dy]==1){
                dfs(isConnected,i_dx,j_dy);
            }
        }

    }
}
