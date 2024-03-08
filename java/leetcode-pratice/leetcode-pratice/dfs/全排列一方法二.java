package com.boshrong.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class 全排列一方法二 {
    public static void main(String[] args) {
        permute(new int[]{0,1});
    }

    public static List<List<Integer>> permute(int[] nums) {
        int lens=nums.length;
        List<List<Integer>>  res=new ArrayList<>();
        if(lens==0){
            return res;
        }

        boolean [] visted= new boolean[lens];
        ArrayList<Integer> tmp=new ArrayList();
        dfs(nums,res,tmp,visted);
        return res;
    }

    public static void dfs(int [] nums,List<List<Integer>>  res,ArrayList<Integer> tmp,boolean [] visted){
        if(tmp.size()==nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visted[i]==true){
                continue;
            }
            tmp.add(nums[i]);
            visted[i]=true;
            dfs(nums,res,tmp,visted);
            visted[i]=false;
            tmp.remove(tmp.size()-1);

        }
    }
}
