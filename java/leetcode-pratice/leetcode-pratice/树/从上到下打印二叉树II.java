package com.boshrong.leetcode.树;

import com.boshrong.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class 从上到下打印二叉树II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            // 将元素全部取出
            for(int i=queue.size();i>0;i--){
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }

            }
            res.add(list);
        }
        return res;
    }
}
