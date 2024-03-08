package com.boshrong.leetcode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层平均值 {
    public List<Double> averageOfLevels(TreeNode root) {
        // 思路: 二叉树的层序遍历，每一层统计总和，和个数
        List<Double> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int t = queue.size();
            long total = 0;
            for(int i=0;i<t;i++){
                TreeNode tmp = queue.poll();
                total += tmp.val;
                if(tmp.left!=null){
                    queue.offer(tmp.left);
                }
                if(tmp.right!=null){
                    queue.offer(tmp.right);
                }
            }
            res.add(((double)total/(double)t));
        }
        return res;

    }
}
