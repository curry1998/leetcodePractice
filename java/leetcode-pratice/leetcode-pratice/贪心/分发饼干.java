package com.boshrong.leetcode.贪心;

import java.util.Arrays;

public class 分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        // 思路: 贪心，先使用大饼干，
        int n = g.length;
        int m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int i = m-1, j = n-1;
        while(i>=0 && j>=0){
            if(s[i]>=g[j]){
                j--;
                i--;
                res++;
            }else{
                j--;
            }
        }
        return res;
    }
}
