package com.boshrong.leetcode.技巧;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        // 思路: 找规律的题 num[i][j] 的计算 根据 num[i-1][j-1]+num[i-1][j]
        List<List<Integer>> res=new ArrayList<>();
        // 还需一个二维数组保存计算的结果,暂存结果的中间值
        int[][] nums=new int[numRows][numRows];

        for(int i=0;i<numRows;i++){
            List<Integer> tmp=new ArrayList<>();
            nums[i][0]=1;
            tmp.add(nums[i][0]);
            for(int j=1;j<i;j++){
                nums[i][j]=nums[i-1][j-1]+nums[i-1][j];
                tmp.add(nums[i][j]);
            }
            if(i!=0){
                nums[i][i]=1;
                tmp.add(nums[i][i]);
            }

            res.add(tmp);
        }
        return res;
    }
}
