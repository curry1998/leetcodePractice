package com.boshrong.leetcode.排序类似;

public class 快速排序实现 {

    /**
     *
     * @param args
     *  快排基本思想 二分的思想
     *  1．先从数列中取出一个数作为基准数。
     * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
     * 3．再对左右区间重复第二步，直到各区间只有一个数。
     *  注意要返回一个基准的位置
     */

    public static void main(String[] args) {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void quickSort(int [] nums,int left,int right){
        if(left<right){
            // 找基准的位置
            int i=swap(nums,left,right);
            quickSort(nums,left,i-1);
            quickSort(nums,i+1,right);
        }
    }
    public static int swap(int [] nums,int left,int right){
        int val=nums[left];
        while(left<right){
            // 填了一个大于等于，防止了空转
            while(left<right && nums[right]>=val){
                right--;
            }
            nums[left]=nums[right];

            while(left<right && nums[left]<val){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=val;
        return left;
    }
}
