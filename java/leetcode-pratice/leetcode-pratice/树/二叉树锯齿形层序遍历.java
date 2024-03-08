package com.boshrong.leetcode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int layer=0;
        while(!queue.isEmpty()){
            int t=queue.size();
            ArrayList<Integer> tmp_res=new ArrayList<>();
            if(layer%2==0){
                for(int i=0;i<t;i++){
                    TreeNode tmp =queue.pollFirst();
                    tmp_res.add(tmp.val);
                    if(tmp.left!=null){
                        queue.add(tmp.left);
                    }
                    if(tmp.right!=null){
                        queue.add(tmp.right);
                    }
                }
            }else{
                for(int i=0;i<t;i++){
                    TreeNode tmp =queue.pollLast();
                    tmp_res.add(tmp.val);
                    if(tmp.right!=null){
                        queue.addFirst(tmp.right);
                    }
                    if(tmp.left!=null){
                        queue.addFirst(tmp.left);
                    }
                }
            }
            layer++;
            res.add(tmp_res);
        }
        return res;

    }

}
