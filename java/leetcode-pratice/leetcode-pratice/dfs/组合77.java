package com.boshrong.leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 组合77 {
    public static void main(String[] args) {
        //System.out.println(combine(4,2));
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<10;i++){
            arrayList.add(i);
        }
        ArrayList<Integer> arrayList2=arrayList;
        ArrayList<Integer> arrayList1 = new ArrayList<>(arrayList);
        System.out.println(arrayList1==arrayList);
        System.out.println(arrayList2==arrayList);
    }

    public static void dfs(int n,int k,int start,LinkedList<Integer>  tmp,List<List<Integer>> resultList){
        if(tmp.size()==k){
            //需要重新赋个值 result 根据tmp 进行变化
            resultList.add(new ArrayList<>(tmp));
            return;
        }
        // 这个遍历是取1 取2...
        for(int i=start;i<=n;i++){
            tmp.addLast(i);
            //已去i, 剩下的开始，避免重复
            dfs(n,k,i+1,tmp,resultList);
            tmp.removeLast();
        }

    }
    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        if(n<1||k<1){
            return result;
        }
        // 这里用 双端队列 是自己之前没有考虑到的
        LinkedList<Integer> queue = new LinkedList<>();
        dfs(n,k,1,queue,result);
        return result;
    }
}
