package com.boshrong.leetcode.排序类似;

public class 数字在升序数组中出现的次数jz53 {
    public static void main(String[] args) {
        int [] array= new int[]{3,3,3,3};
        GetNumberOfK(array,3);
    }

    public static int GetNumberOfK(int [] array , int k) {
        int lens=array.length;
        if (lens<0){
            return 0;
        }

        if(lens==1){
            if(array[lens-1]==k){
                return 1;
            }
        }
        int left=0;
        int right=lens-1;
        int  result=0;
        while(left<right){
            int mid;
            mid=(left+right)/2;
            if(array[mid]==k){
                //找到了
                mid--;
                while(mid>=0 &&array[mid]==k){
                    mid--;
                }
                //mid在第一个与k 不同的位置
                mid++;
                while(mid<=lens-1 && array[mid]==k){
                    mid++;
                    result++;
                }
                break;
            }
            if(array[mid]>k){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return result;
    }
}
