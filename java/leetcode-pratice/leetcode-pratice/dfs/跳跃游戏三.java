package com.boshrong.leetcode.dfs;

public class 跳跃游戏三 {
    public boolean canReach(int[] arr, int start) {
        // 思路 dfs
        int n = arr.length;
        boolean [] visited= new boolean[n];
        boolean flag=dfs(arr, start,visited);

        return flag;
    }
    // 类似与二叉树
    public boolean dfs(int [] arr,int start,boolean [] visited){
        if(start<0 || start>=arr.length || visited[start]){
            return false;
        }
        if(arr[start]==0){
            return true;
        }
        visited[start]=true;
        boolean left = dfs(arr,start+arr[start],visited);
        boolean right = dfs(arr,start-arr[start],visited);
        return left||right;
    }
}
