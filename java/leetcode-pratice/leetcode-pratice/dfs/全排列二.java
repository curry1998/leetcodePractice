package com.boshrong.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列二 {
    int [] nums;
    int lens;
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        lens=nums.length;
        res=new ArrayList<>();
        if(lens==0){
            return res;
        }
        Arrays.sort(nums);
        this.nums=nums;
        ArrayList<Integer> tmp=new ArrayList<>();
        boolean [] visted=new boolean[lens];
        dfs(tmp,visted);
        return res;
    }
    public void dfs(ArrayList<Integer> list,boolean [] visted){
        if(list.size()==lens){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<lens;i++){
            if(visted[i]==true){
                continue;
            }
            if(i>0 && nums[i]==nums[i-1]&&visted[i-1]==false){
                continue;
            }
            list.add(nums[i]);
            visted[i]=true;
            dfs(list,visted);
            visted[i]=false;
            list.remove(list.size()-1);
        }

    }
}
