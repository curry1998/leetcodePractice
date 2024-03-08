package com.boshrong.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列46 {

    public static void main(String[] args) {
        int [] nums=new int[]{1,2,3};
        System.out.println(permute(nums));
    }

    //这道和电话号码那道题比较像
    // 出问题出在了nums
    public static void dfs(List<Integer> nums,List<Integer> list,List<List<Integer>> result){
        // nums存放剩余的数
        int lens=nums.size();
        if(lens==0){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<lens;i++){

            list.add(nums.get(i));
            //新开辟一段空间
            ArrayList<Integer> arrayList = new ArrayList<>(nums);
            arrayList.remove(i);
            dfs(arrayList,list,result);
            int len=list.size();
            list.remove(len - 1);
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        int lens=nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(lens<1){
            return result;
        }
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> numsArray = new ArrayList<>();
        for(int i=0;i<lens;i++){
            numsArray.add(nums[i]);
        }
        dfs(numsArray,list,result);
        return result;
    }
}
