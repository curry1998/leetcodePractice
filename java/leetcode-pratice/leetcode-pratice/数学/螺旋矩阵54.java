package com.boshrong.leetcode.数学;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵54 {
    public static void main(String[] args) {

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m =matrix.length;
        int n = matrix[0].length;
        // 构建顺时针的方向
        int [] row= new int[]{0,1,0,-1};
        int [] col= new int[]{1,0,-1,0};
        //边界是访问到所有的节点
        int total=m*n;
        boolean [][] visited=new boolean[m][n];
        ArrayList<Integer> res=new ArrayList<>();

        int idx=0;
        // 当前节点的坐标
        int i=0;
        int j=0;

        while(total!=0){
            if(i>=0 && i<m && j>=0 && j<n && visited[i][j]==false){
                total--;
                visited[i][j]=true;
                res.add(matrix[i][j]);
                i+=row[idx];
                j+=col[idx];
            }else{
                i-=row[idx];
                j-=col[idx];
                // 需要转弯
                idx++;
                if(idx==4){
                    idx=0;
                }
                i+=row[idx];
                j+=col[idx];

            }
        }
        return res;

    }
}
