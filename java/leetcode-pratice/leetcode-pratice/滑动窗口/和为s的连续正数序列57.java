package com.boshrong.leetcode.滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 和为s的连续正数序列57 {

    public static void main(String[] args) {
        System.out.println(findContinuousSequence(15));
    }
    // 使用滑动窗口解题
    public static int[][] findContinuousSequence(int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(target<1){
            return null;
        }
        int left = 1, right = 1;
        // 存放arrayList 里面的总和
        int count = 1;
        int max_lens = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        while(right<target){
            //检查是否满足条件
            if(count == target){
                list.add( new ArrayList<>(arrayList));
                if(arrayList.size() > max_lens){
                    max_lens=arrayList.size();
                }
                left++;
                arrayList.remove(0);
                right++;
                arrayList.add(right);
                count += right-left+1;
                continue;

            }else if (count > target){
                count -= arrayList.get(0);
                left ++;
                arrayList.remove(0);
            }else{
                right++;
                count += right;
                arrayList.add(right);
            }
        }
        // 返回最终结果
        int lens2=list.size();
        int [][] arrayResult=new int[lens2][max_lens];
        for(int i=0;i<lens2;i++){
            int len3=list.get(i).size();
            for(int k=0;k<len3;k++){
                arrayResult[i][k]=list.get(i).get(k);
            }
        }
        return arrayResult;
    }
}
