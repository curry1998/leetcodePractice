package com.boshrong.leetcode.排序类似;

import java.util.Arrays;

public class 颜色的分类75 {
    public void sortColors(int[] nums) {
        // 思路: 原地排序 常数空间的扫描算法,不能新开辟一个空间。 分成两段 一个遍满足要求数的集合，一个要遍历的数
        // 0 1 2 代表红白蓝 因为其独特性 只有 0 1 2 三种元素 定义三个常数  x y z分别代表在满足要求的集合中 0结束的位置 1 结束的位置 2 结束的位置
        // 遍历数为0 x y z 自增，并且分别赋值为0 1 2 从后望前走
        int lens=nums.length;
        int x=0,y=0,z=0;
        for(int i=0;i<lens;i++){
            if(nums[i]==0){
                //先赋值再自增
                nums[z++]=2;
                nums[y++]=1;
                nums[x++]=0;


            }else if(nums[i]==1){
                nums[z++]=2;
                nums[y++]=1;

            }else{
                nums[z++]=2;
            }
        }

    }
}
