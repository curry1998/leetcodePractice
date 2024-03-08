package com.boshrong.leetcode.排序类似;

public class 直接插入排序 {
    public static void main(String[] args) {
        insertOrder(new int[]{4,5,6,7,1,3,4});
    }

    public static void insertOrder(int [] nums){
        int lens=nums.length;
        for(int i=1;i<lens;i++){
            int val=nums[i];
            // 从后向前走，进行比较
            int j;
            for(j=i-1;nums[j]>val && j>0;j--){
                nums[j+1]=nums[j];
            }
            nums[j+1]=val;
        }

        for(int i=0;i<lens;i++){
            System.out.println(nums[i]);
        }
    }

}
