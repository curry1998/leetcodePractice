package com.boshrong.leetcode.技巧;

public class 调整数组顺序使奇数位于偶数前面 {
    public int[] reOrderArray (int[] array) {
        if(array.length==0)
            return array;
        //int[] ints = new int[]{};
        // 上一个不是奇数的位置进行保留
        int flag=0;// flag 存现已排好的奇数位置
        int n=array.length;
        // 先后移再放
        for(int k=0;k<n;k++){
            if(array[k]%2!=0){
                int temp=array[k];
                if(k==0){
                    array[k]=temp;
                }else{

                    for(int j=k-1;j>flag;j--){
                        array[j+1]=array[j];
                    }
                    flag++;
                    array[flag]=temp;

                }

            }else{
                if(k==0){
                    flag=-1;
                }
            }
        }
        return  array;
    }
}




