package com.boshrong.leetcode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的右视图199 {
    public List<Integer> rightSideView(TreeNode root) {
        // 思想: 层序遍历，每次获取每一层最后的元素

        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int t = queue.size();
            for(int i =0;i <t;i++){
                if(i ==t-1){
                    res.add(queue.peek().val);
                }
                TreeNode tmp = queue.poll();
                if(tmp.left !=null){
                    queue.add(tmp.left);
                }
                if(tmp.right!=null){
                    queue.add(tmp.right);
                }
            }
        }
        return res;
    }
}
