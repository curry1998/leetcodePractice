package com.boshrong.leetcode.dp;

import java.util.List;

public class 三角形最小路径和120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 三角形最小路径和 思路动态规划 f[i][j] 表示 0 0到i,j 的最小路径和 f[i][j]=min(f[i-1][j],f[i-1][j+1])+triangle[i][j]
        // 这道题主要是有的上面没有需要进行特别判断
        int len1=triangle.size();
        int len2=triangle.get(len1-1).size();
        int [][] f=new int [len1][len2];
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++)
                f[i][j]=-10001;
        }
        f[0][0]=triangle.get(0).get(0);
        for(int i=1;i<len1;i++){
            for(int j=0;j<=i;j++){
                //有的上面没有数 f[i-1][j-1]肯定有
                if(f[i-1][j]==-10001){
                    f[i][j]=f[i-1][j-1]+triangle.get(i).get(j);
                }else if(j-1<0){
                    // 左边没有只能从上面来
                    f[i][j]=f[i-1][j]+triangle.get(i).get(j);
                }
                else{
                    f[i][j]=Math.min(f[i-1][j],f[i-1][j-1])+triangle.get(i).get(j);
                }
            }
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<len2;i++){
            if(f[len1-1][i]<res){
                res=f[len1-1][i];
            }
        }
        return res;
    }
}
