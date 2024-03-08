package com.boshrong.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class 组合总数39 {
    public static void main(String[] args) {
        combinationSum(new int[]{2,3,6,7},7);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int lens=candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList();
        dfs(candidates,tmp,res,0,target);
        return res;
    }
    // 主要有个无限重复被选取(无限重复选取可以当做一个进入分支的条件) 只有小于target 的才能被选取 每次dfs 可以选择.
    // 怎么也是选与不选的关系 ，选了可能重复选 col 当前在数组的那一位
    public  static void dfs(int[] candidates,ArrayList<Integer> tmp, List<List<Integer>> res,int col,int target){
        if(target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i= col;i<candidates.length; i++){
            tmp.add(candidates[i]);
            dfs(candidates,tmp,res,col,target-candidates[i]);
            tmp.remove(tmp.size()-1);
        }
    }
}
