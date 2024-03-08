package com.boshrong.leetcode.滑动窗口;

public class 水果成篮904 {
    public int totalFruit(int[] fruits) {
        // 思想:  水果种类, 滑动窗口
        // 维护left 和 right，每次取两个数作为基准，right 向右滑动
        // 如果fruit[right] 不是篮子里面的值，更新l，当前的r的左边
        int n = fruits.length;
        int l = 0,r =0;
        int sl=fruits[l],sr=fruits[r];
        int res =1;
        while(r<n){
            if(fruits[r]==sl || fruits[r]==sr){
                if(r-l+1>res){
                    res =r-l+1;
                }
                r++;
            }else{
                // 更新l，当前的r的左边
                l = r-1;
                sl = fruits[l];
                sr = fruits[r];
                // 存在 1 2 1 1 3 这种情况
                while(l>=1 && fruits[l-1]==sl){
                    l--;
                }
                if(l-r+1>res){
                    res = l-r+1;
                }
            }
        }
        return res;
    }
}
