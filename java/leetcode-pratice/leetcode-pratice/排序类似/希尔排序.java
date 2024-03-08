package com.boshrong.leetcode.排序类似;

public class 希尔排序 {
    public static void main(String[] args) {
        int [] arr=new int[]{2,5,9,7,4,3,9,6,8,11,20,45,17};
        shellSort(arr);
    }
    public static void shellSort(int [] nums){
        int lens=nums.length;
        // 增量

    }
    public void printArr(int []nums){
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
