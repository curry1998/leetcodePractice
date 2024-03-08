package com.boshrong.leetcode.排序类似;

public class 旋转数组的最小数字jz11 {
    public static void main(String[] args) {
        int [] array=new int[]{1,0,1,1,1};
        minNumberInRotateArray(array);
    }

    public static int minNumberInRotateArray(int [] array) {
        int lens=array.length;
        if(lens<0){
            return 0;
        }
        //空间复杂度o(1) 时间复杂度o(logn)，是排序的(有可能是相等的)，可以采用二分
        // 二分的问题是与左边比还是与右边比，刚开始的时候是用左边的进行对比发现相等的情况不好处理。
        int left=0;
        int right=lens-1;
        while(left< right){
            //如果array[left]<array[right]直接返回
            if(array[left]<array[right]){
                return array[left];
            }
            int mid;
            mid=(left+right)/2;
            if(array[left]<array[mid]){
                // array[left]<array[mid] 说明 left 到mid 之间位置没有变换过
                left=mid;
                continue;
            }else if (array[left]>array[mid]){
                // array[left]>array[mid] 说明left 之间存在最小值
                right=mid;
                continue;
            }else{
                //相等的情况，最小值可能在左边也可能在右边 eg: 1 0 1 1 1  和 2 2 2 1 2 这时候需要特殊处理
                // right++ 逐渐缩小空间
                left++;
            }

        }
        return array[left];
    }
}
