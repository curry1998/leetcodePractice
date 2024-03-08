package com.boshrong.leetcode.dfs;

import java.util.*;

public class 组合总数二 {
    private int [] candidates;
    private int target;
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        this.candidates=candidates;
        this.target=target;
        this.res=new ArrayList<>();
        ArrayList<Integer> path=new ArrayList<>();
        Arrays.sort(this.candidates);
        dfs(path,0,0);
        return res;
    }
    public void dfs(ArrayList<Integer> combine,int num,int col){
        if(col>this.candidates.length){
            return;
        }

        if(num==this.target){
            this.res.add(new ArrayList<>(combine));
            return ;
        }

        for(int i=col;i<this.candidates.length;i++){
            if(num+this.candidates[i]>target){
                break;
            }

            combine.add(this.candidates[i]);
            // 之前写错是因为写成了 col+1
            dfs(combine,num+this.candidates[i],i+1);
            combine.remove(combine.size()-1);

            while(i<this.candidates.length-1 && this.candidates[i]==this.candidates[i+1]){
                i++;
            }

        }
    }
}
