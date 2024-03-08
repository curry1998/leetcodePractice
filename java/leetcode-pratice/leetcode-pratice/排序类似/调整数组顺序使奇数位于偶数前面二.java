package com.boshrong.leetcode.排序类似;

public class 调整数组顺序使奇数位于偶数前面二 {
    public static void main(String[] args) {
        reOrderArrayTwo(new int[]{1,3,5,4,7});
    }
    public static int[] reOrderArrayTwo (int[] array) {
        // 时间复杂度o(n) 空间时间复杂度 o(1)
        // write code here
        int lens=array.length;
        if(lens<0){
            return new int[]{};
        }

        // left 指现存数组第一个偶数，right 向后移，遇到奇数进行交换
        for(int left=0,right=0;right<lens;right++){
            if(array[right]%2==0){
                continue;
            }else{
                //为奇数，与前面的偶数(注意left 可能)进行交换
                int tmp;
                tmp=array[left];
                array[left]=array[right];
                array[right]=tmp;
                left++;
            }

        }
        return array;
    }
}
