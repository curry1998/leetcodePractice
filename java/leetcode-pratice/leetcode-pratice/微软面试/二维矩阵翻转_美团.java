package com.boshrong.leetcode.微软面试;

import java.util.Scanner;

public class 二维矩阵翻转_美团 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m =sc.nextInt();
        int[][] ints = new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ints[j][i]=sc.nextInt();
            }
        }
        sc.close();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(ints[i][j]+" ");
            }
            System.out.println();
        }
    }
}
