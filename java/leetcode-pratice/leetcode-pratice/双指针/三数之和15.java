package com.boshrong.leetcode.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和15 {

    public static void main(String[] args){
        int [] nums={-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        int lens=nums.length;
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if(lens<3) {
            return lists;
        }
        // 进行排序,默认升序
        Arrays.sort(nums);
        for (int i=0;i<lens-2;i++){

            if(nums[i]>0){
                break;
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=lens-1;

            while (left<right){
                // 如何去重
                if(nums[i]+nums[left]+nums[right]==0){
                    lists.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[left],nums[right])));
                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if (nums[i]+nums[left]+nums[right]>0){
                    right--;
                }else{
                    left++;
                }
            }

        }
        return lists;
    }
}
