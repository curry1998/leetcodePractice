package com.boshrong.leetcode.数学;

public class 螺旋矩阵二 {
    public static void main(String[] args) {
        generateMatrix(3);
    }
    // //遍历四个方向 左闭右开, sx, sy 每一圈开始的位置。
    // 定一个一个偏移量 偏移量每次+2, sy每次增长一 sy+n-offeset 确定边界
    public  static int[][] generateMatrix(int n) {
        int [][] res = new int [n][n];
        int sx=0,sy=0;
        int offset=1;
        // 所需要的圈数
        int loop = n/2;
        int i,j;
        int val = 0;
        while(loop>0){
            //sx, sy 规定了边界的大小
            i = sx;
            j = sy;
            //遍历四个方向 左闭右开
            for(; j < sy + n-offset;j++){
                res[sx][j] = val++;
            }
            for(; i < sx + n-offset;i++){
                res[i][j] = val++;
            }
            for(; j > sy; j--){
                res[i][j] = val++;
            }
            for( ; i > sx; i--){
                res[i][j] = val++;
            }
            offset += 2;
            // 下一圈的起点
            sx++;
            sy++;
            loop--;
        }
        if(n%2==0){
            res[n/2][n/2] = val;
        }
        return res;

    }
}
