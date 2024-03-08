package com.boshrong.leetcode.队列栈;

import org.apache.tomcat.util.digester.ArrayStack;

import java.util.HashMap;
import java.util.LinkedList;

public class 单调栈下一个更大元素 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //没有重复元素数组 nums1 nums2
        // 单调栈达到其时间复杂度，从后向前扫描，将其入栈。如果栈为空返回-1，当前栈的元素小于
        // 当前元素，不断出栈。
        HashMap<Integer,Integer> map=new HashMap<>();
        LinkedList<Integer> stack=new LinkedList<>();
        int lens=nums2.length;
        for(int i=lens-1;i>=0;i--){
            int t=nums2[i];
            while(stack.size()!=0 && stack.peek()<t){
                stack.pop();
            }
            int val= stack.size()==0? -1:stack.peek();
            map.put(t,val);
            stack.push(t);
        }

        int lens2=nums1.length;
        int [] res=new int[lens2];
        for(int i=0;i<lens2;i++){
            res[i]=map.get(nums1[i]);
        }
        return res;
    }
}
