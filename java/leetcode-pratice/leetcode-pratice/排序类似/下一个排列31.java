package com.boshrong.leetcode.排序类似;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

import java.util.Arrays;
import java.util.Collections;

public class 下一个排列31 {
    public static void main(String[] args) {

        nextPermutation(new int []{3,2,1});
    }
    public static void nextPermutation(int[] nums) {
        int lens=nums.length;
        if (lens<2){
            return;
        }
        // 找到k
        int k=-1;
        for(int i=lens-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                k=i;
                break;
            }else{
                continue;
            }
        }
        if(k==-1){
            for(int i=0;i<lens/2;i++){
                int tmp=nums[lens-i-1];
                nums[lens-i-1]=nums[i];
                nums[i]=tmp;
            }
        }
        // 找到l 并进行交换
        for(int i=lens-1;i>k;i--){
            if(nums[i]>nums[k]){
                int tmp=nums[i];
                nums[i]=nums[k];
                nums[k]=tmp;
                break;
            }
        }
        //k 之后的进行翻转
        int len=lens-k;
        for(int i=0;i<len/2;i++){
            int tmp=nums[lens-i-1];
            nums[lens-i-1]=nums[k+1+i];
            nums[k+1+i]=tmp;
        }
    }
}
