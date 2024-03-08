package com.boshrong.leetcode.dfs;

public class 被围绕的区域130 {
    //四个方向 上 右 下 左
    int [] dx = new int[]{-1,0,1,0};
    int [] dy = new int[]{ 0,1,0,-1};
    public void solve(char[][] board) {
        // 思路: mxn 的矩阵，被X围绕的区域，被围绕的区间不会存在与边界 水平和垂直方向相邻
        // 先将里面的全部转化为 x ,再往里面递归
        int n = board.length;
        int m = board[0].length;
        boolean [][] visited=new boolean [n][m];
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(board[i][j]=='O'){
                    // true 代表着以前为o
                    visited[i][j]=true;
                    board[i][j]='X';
                }
            }
        }
        // 遍历四个角
        for(int i = 0;i < n;i++){
            if(board[i][0] == 'O')
                dfs(i,0,board,visited);
            if(board[i][m-1] == 'O')
                dfs(i, m-1, board,visited);
        }
        for(int i = 0;i < m;i++){
            if(board[0][i] == 'O')
                dfs(0,i,board,visited);
            if(board[n-1][i] == 'O')
                dfs(n-1,i,board,visited);
        }

    }
    public void dfs(int i,int j,char[][] board,boolean[][] visited){

        for(int k = 0; k < 4;k++){
            int newX=i+dx[k];
            int newY=j+dy[k];
            if(newX>=1 && newX<board.length-1 && newY>=1 && newY<board[0].length-1 && visited[newX][newY]==true){
                board[newX][newY]='O';
                visited[newX][newY]=false;
                dfs(newX,newY,board,visited);
            }
        }
    }
}
