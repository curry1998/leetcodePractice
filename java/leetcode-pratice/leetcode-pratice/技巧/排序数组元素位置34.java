package com.boshrong.leetcode.技巧;

public class 排序数组元素位置34 {
    public int[] searchRange(int[] nums, int target) {

        int lens=nums.length;
        if(lens==0){
            return new int[]{-1,-1};
        }
        int [] res=new int[2];
        int l=0,r=lens-1;
        while(l<r){
            int mid=(l+r+1)/2;
            if(target>=nums[mid]){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        if(nums[l]!=target){
            return new int[]{-1,-1};
        }
        l--;
        r++;
        while(l>=0 && nums[l]==target){
            l--;
        }
        while(r<=lens-1 && nums[r]==target){
            r++;
        }
        res[0]=l+1;
        res[1]=r-1;
        return res;
    }
}
