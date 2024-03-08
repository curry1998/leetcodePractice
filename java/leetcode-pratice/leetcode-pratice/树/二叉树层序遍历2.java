package com.boshrong.leetcode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树层序遍历2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //思路:  层序遍历，数组进行reverse.


        LinkedList<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();

        while(!queue.isEmpty()){
            ArrayList tmp=new ArrayList<>();
            int t=queue.size();
            for(int i=0;i<t;i++){
                TreeNode poll=queue.poll();
                tmp.add(poll.val);
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }

            }
            res.add(tmp);
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i=res.size()-1;i>=0;i--){
            list.add(res.get(i));
        }
        return list;
    }
}
