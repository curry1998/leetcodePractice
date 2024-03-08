package com.boshrong.leetcode.双指针;

public class 接雨水 {
    public int trap(int[] height) {
        // 某个柱子i 所能接到的最大雨水的高为其左右柱子离其最近且高度较小的。
        // 即每一列的雨水的高度取决于其左侧最高柱子和右侧最高柱子中最矮的那个柱子高度。

        // 使用一个数组保存 当前位置 i 左边离其最近的较高的柱子。同理右边也进行保存
        // 接雨水 可以通过双指针法， 动态规划， 单调栈实现
        int n=height.length;
        int [] left=new int[n];
        int [] right =new int[n];
        int res=0;
        // 这个代表左边 0号位置的左边为0
        //
        left[0]=height[0];
        right[n-1]=height[n-1];
        for(int i=1;i<=n-1;i++){
            left[i]=Math.max(left[i-1],height[i]);
        }
        for(int i=n-2;i>=0;i--){
            right[i]=Math.max(right[i+1],height[i]);
        }
        // 不考虑两个边界，因为其接不雨水
        for(int i=1;i<n-1;i++){
            res+=Math.min(left[i],right[i])-height[i];
        }
        return res;
    }
}
