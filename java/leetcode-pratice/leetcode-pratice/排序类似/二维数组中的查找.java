package com.boshrong.leetcode.排序类似;

public class 二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] array, int target) {
        // 思想:  先找最后一列 如果target大于这个数 向下走，直到target小于列的数。从右向左走，找到第一个，找到第一个小于target的数，向下走。
        boolean flag=false;
        int row = array.length;
        if(row == 0){
            return false;
        }
        int column = array[0].length;
        if(column == 0){
            return false;
        }
        // 在for 循环中定义两个坐标
        for(int i = 0,j = column-1;((i >= 0 && i < row) && (j >= 0 && j < column));){
            if(array[i][j]==target){
                flag =true;
                break;
            }
            else if(array[i][j]>target){
                j--;
            }else{
                i++;
            }
        }
        return flag;
    }
}
