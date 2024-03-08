package com.boshrong.leetcode.树;

import com.boshrong.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class 之字形打印二叉树jz77 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int layer=1;
        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            // 将元素全部取出
            if(layer%2!=0){
                //从左向右取
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
            }else{
                //从右向左取,只取不进行删除
                for(int i=queue.size()-1;i>=0;i--){
                    TreeNode treeNode = queue.get(i);
                    list.add(treeNode.val);
                }
                //这里的i 只是一个计数元素，其实还是从队列小端到大端
                for(int i=queue.size();i>0;i--){
                    TreeNode poll = queue.poll();
                    if(poll.left!=null){
                        queue.add(poll.left);
                    }
                    if(poll.right!=null){
                        queue.add(poll.right);
                    }
                }

            }
            layer++;
            res.add(list);
        }
        return res;

    }
}
