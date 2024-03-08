package com.boshrong.leetcode.并查集;

import java.util.Arrays;

public class 判断图有没有环 {

    public boolean findCircleNum(int[][] isConnected) {
        // 并查集，这道题  将所有节点加入到其相应的集合，最后统计集合的个数，就是省份的数量
        // 给定的是一个二维矩阵
        int lens = isConnected.length;
        int[] parents = new int[lens];
        Arrays.fill(parents, -1);
        for (int i = 0; i < lens; i++) {
            for (int j = 0; j < lens; j++) {
                // 为一条边
                if (i != j && isConnected[i][j] == 1) {
                    // i j 是一条边
                    if (unionPoint(i, j, parents) == 0) {
                        return true;
                    }

                }
            }
        }
        return false;
    }
    // 合并两个节点
    public int unionPoint(int x, int y, int [] parents){
        int xRoot = findRoot(x, parents);
        int yRoot = findRoot(y, parents);
        if(xRoot == yRoot){
            // 有相同的根节点说明有环
            return 0;
        }else{
            parents[xRoot]= yRoot;
            return 1;
        }

    }
    // 找到某个节点的根
    public int findRoot(int x, int [] parents ){
        int t =x;
        //根节点为-1
        while(parents[t]!=-1){
            t = parents[t];
        }
        return t;
    }
}
