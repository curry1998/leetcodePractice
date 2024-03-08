package com.boshrong.leetcode.排序类似;

public class 数组中的逆序对51 {

    public static void main(String[] args) {
        int[] nums=new int[]{4,5,6,7};
        int mum=Integer.MAX_VALUE;
        //System.out.println(reversePairs(nums));
    }
    // 使用归并的思想进行解决
    // 求逆序对，前面的大于后面的
    //  一个 1 4 7 另一个 3 5 9 如果 第一个里面大于后面的count ++
    int count=0;
    int[] ints;
    void MergeSort(int [] nums,int low, int high){
        if(low<high){
            int mid=(low+high)/2;
            MergeSort(nums,low,mid);
            MergeSort(nums,mid+1,high);
            Merge(nums,low,mid,high);
        }
    }
     void  Merge(int [] nums,int low,int mid,int hight){

        for(int k=low;k<=hight;k++){
            ints[k]=nums[k];
        }

        int i;
        int j;
        int k;
        for( i=low,j=mid+1, k=low ;i<=mid&&j<=hight;k++) {

            if (ints[i] <= ints[j]) {
                nums[k] = ints[i++];

            } else {
                //num[i] 大于num[j]因为其是有序的，i到mid 之后的都大于num[j]
                nums[k] = ints[j++];
                int kk = mid - i + 1;
                count += kk;
            }
        }
            while(i<=mid){

                nums[k++]=ints[i++];

            }

            while(j<=hight){
                nums[k++]=ints[j++];
            }
        }


    public  int reversePairs(int[] nums) {
        int lens=nums.length;
        if(lens<1){
            return 0;
        }
        ints=new int[lens];
        MergeSort(nums,0,lens-1);
        // 为什么没变化？
        return count;
    }
}
