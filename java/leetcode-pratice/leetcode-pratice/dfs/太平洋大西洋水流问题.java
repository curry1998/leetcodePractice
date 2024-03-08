package com.boshrong.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class 太平洋大西洋水流问题 {
    int [][] heights;
    int len1;
    int len2;
    int [] dx=new int[]{1,0,0,-1};
    int [] dy=new int[]{0,1,-1,0};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights=heights;
        this.len1=heights.length;
        this.len2=heights[0].length;
        List<List<Integer>> res=new ArrayList<>();
        boolean [][] PToA=new boolean[len1][len2];
        boolean [][] AToP =new boolean[len1][len2];
        for(int i=0;i<len1;i++){
            dfs(i,0,PToA);
        }
        for(int i=0;i<len2;i++){
            dfs(0,i,PToA);
        }
        for(int i=0;i<len2;i++){
            dfs(len1-1,i,AToP);
        }
        for(int i=0;i<len1;i++){
            dfs(i,len2-1,AToP);
        }
        for(int i=0;i<=len1-1;i++){
            for(int j=0;j<=len2-1;){
                // 这个点进行填入
                if(PToA[i][j]==true&& AToP[i][j]==true){
                    ArrayList<Integer> tmp=new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    res.add(tmp);
                }
            }
        }
        return res;
    }
    public void dfs(int x,int y,boolean [][] visited){
        if(visited[x][y]){
            return;
        }
        visited[x][y]=true;
        for(int i=0;i<4;i++){
            int newX=x+dx[i];
            int newY=y+dy[i];
            if(newX>=0 && newX<len1 && newY>=0 && newY<len2 && heights[x][y]>heights[newX][newY]){
                dfs(newX,newY,visited);
            }
        }
    }
}
