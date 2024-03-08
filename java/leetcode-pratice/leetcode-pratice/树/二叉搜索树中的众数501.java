package com.boshrong.leetcode.树;

import java.util.ArrayList;

public class 二叉搜索树中的众数501 {

    int maxCount = 0;
    TreeNode pre;
    int count = 0;
    public int[] findMode(TreeNode root) {
        //二查搜索数中的众数，可以转化成有序数组中统计出现次数较多的数,使用前驱。
        ArrayList<Integer> res = new ArrayList<>();
        dfs(res, root);
        // 转化为数组
        int [] tempRes = new int [res.size()];
        for(int i = 0;i < tempRes.length;i++){
            tempRes[i] = res.get(i);
        }
        return tempRes;

    }
    public void dfs(ArrayList<Integer> res, TreeNode root){
        if(root == null){
            return;
        }
        dfs(res,root.left);
        if(pre != null && pre.val !=root.val){
            count = 1;
        }else {
            count++;
        }

        if(count > maxCount){
            maxCount = count;
            res.clear();
            res.add(root.val);
        }else if (count == maxCount){
            res.add(root.val);
        }
        pre = root;
        dfs(res,root.right);
    }
}
