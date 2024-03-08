package com.boshrong.leetcode.滑动窗口;

import java.util.ArrayList;


public class 滑动窗口的最大值 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] ints = {2, 3, 4, 2, 6, 2, 5, 1};
        solution3.maxInWindows(ints,3);
    }
}

 class Solution3 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
//        if (num.length == 0||size==0)
//            return null;
//        int n = num.length;
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        //可以把linkedList 当双端queue 来用
//        LinkedList<Integer> integers = new LinkedList<>();
//        int left=0,right=0;
//        while(right<n){
//            if(integers.isEmpty()){
//                integers.add(num[right]);
//            }else{
//                //接入一个元素的时候，队尾数小于该元素，删除对尾元素直到队尾元素等于或大于该元素
//                for(;!integers.isEmpty()&&integers.getLast()<num[right];){
//                    integers.removeLast();
//
//                }
//                integers.addLast(num[right]);
//
//            }
//            right++;
//
//            if(right-left==size){
//                arrayList.add(integers.getLast());
//                if(integers.size()>0&& num[left]==integers.getFirst()){
//                    integers.removeFirst();
//                }
//                left++;
//            }
//
//        }
//        return arrayList;

        // 暴力解法
        ArrayList<Integer> arrayList = new ArrayList<>();
        int n=num.length;
        int left=0,right=size-1;
        while(right<n){
            int res=getMax(num,left,right,size);
            arrayList.add(res);
            right++;
            left++;
        }
        return arrayList;
    }

    public Integer getMax(int [] nums,int left,int right,int size){
        int res=nums[right];
        for(int i=right;i>=left;i--){
           if(nums[i]>res){
               res=nums[i];
           }
        }
        return res;
    }

    }







