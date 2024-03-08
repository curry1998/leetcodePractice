package com.boshrong.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class 全排列方法三 {
    // 这个方法借鉴了戳气球，没有新开辟空间
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        int lens= nums.length;
        res=new ArrayList<>();
        if(lens ==0){
            return res;
        }
        ArrayList<Integer> Arraynum=new ArrayList<>();
        for(int i=0;i<lens;i++){
            Arraynum.add(nums[i]);
        }
        ArrayList<Integer> tmp=new ArrayList<>();
        dfs(Arraynum,tmp);
        return res;
    }
    public void dfs(ArrayList<Integer> nums,ArrayList<Integer> tmp){
        if(nums.size()==0){
            res.add(new ArrayList<>(tmp));
        }
        for(int i=0;i<nums.size();i++){
            int num=nums.remove(i);
            tmp.add(num);
            dfs(nums,tmp);
            tmp.remove(tmp.size()-1);
            nums.add(i,num);
        }
    }
}
