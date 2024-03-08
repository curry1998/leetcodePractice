package com.boshrong.leetcode.技巧;

public class 删除有序数组中的重复项26 {
    public int removeDuplicates(int[] nums) {
        int lens=nums.length;
        if(lens==1 || lens==0){
            return lens;
        }

        int i=1,j=1;
        while(j<lens){
            if(nums[i-1]!=nums[j]){
                nums[i]=nums[j];
                i++;

            }else{
                j++;
                continue;
            }

            j++;
        }
        return i;
    }
}
