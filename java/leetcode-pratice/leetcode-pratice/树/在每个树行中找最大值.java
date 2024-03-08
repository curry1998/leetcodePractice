package com.boshrong.leetcode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 在每个树行中找最大值 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){

            int t = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for(int i =0;i <t;i++){
                TreeNode tmp = queue.poll();
                if(tmp.val>maxValue){
                    maxValue = tmp.val;
                }
                if(tmp.left !=null){
                    queue.add(tmp.left);
                }
                if(tmp.right!=null){
                    queue.add(tmp.right);
                }
            }
            res.add(maxValue);
        }
        return res;
    }
}
