package com.boshrong.leetcode.哈希;

import java.util.ArrayList;
import java.util.HashSet;

public class 两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set= new HashSet<>();
        int n = nums1.length;
        int m = nums2.length;
        for(int i = 0;i<n;i++){
            set.add(nums1[i]);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int j = 0;j<m;j++){
            if(set.contains(nums2[j])){
                set.remove(nums2[j]);
                res.add(nums2[j]);
            }
        }
        int [] res2 =new  int [res.size()];
        for(int i=0;i<res.size();i++){
            res2[i] = res.get(i);
        }
        return res2;
    }
}
