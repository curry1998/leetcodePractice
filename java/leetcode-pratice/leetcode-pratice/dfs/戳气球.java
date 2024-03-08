package com.boshrong.leetcode.dfs;

import java.util.ArrayList;

public class 戳气球 {
    static int ans =0;
    public int maxCoins(int[] nums) {
        // 思路: 动态规划，回溯解决
        ArrayList<Integer> tmp=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            tmp.add(nums[i]);
        }
        dfs(tmp,0);
        return ans;
    }
    //tmp 保存现有的值
    public void dfs(ArrayList<Integer> nums, int tmp){
        // 递推结束条件,要恢复现场
        if(nums.size() ==0){
            ans= Math.max(tmp,ans);
            return ;
        }
        for(int i=0;i<nums.size();i++){

            //构造结果,放到remove 之前，因为remove 会改变nums.size()
            int s = nums.get(i) *(i-1<0 ? 1: nums.get(i-1)) * ( i+1>nums.size()-1 ? 1:nums.get(i+1));
            int num=nums.remove(i);
            dfs(nums,tmp+s);
            // 把num 添加到第i 个位置，回溯现场
            nums.add(i,num);
        }
    }
}
