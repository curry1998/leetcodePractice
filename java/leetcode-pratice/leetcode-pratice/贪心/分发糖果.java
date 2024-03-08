package com.boshrong.leetcode.贪心;

public class 分发糖果 {
    public int candy(int[] ratings) {
        // 两次遍历，第一次从左向右，先查看右孩子比左孩子的，如果右孩子比左孩子的评分高，右孩子的糖果比左孩子要多一颗糖。
        // 第二次从右往左遍历（其目的是为了遍历中已经复用的结果），如果左孩子比右孩子的评分高，则左孩子的糖果要比右孩子多，去之前结果和右      //孩子糖果+1 中的最大值
        int n = ratings.length;
        int [] candys= new int [n];
        int res =0;
        candys[0]=1;
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                candys[i] = candys[i-1]+1;
            }else{
                candys[i] = 1;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                // 也要满足之前的条件
                candys[i] = Math.max(candys[i+1]+1,candys[i]);
            }
        }

        for(int i=0;i<n;i++){
            res+=candys[i];
        }
        return res;
    }
}
