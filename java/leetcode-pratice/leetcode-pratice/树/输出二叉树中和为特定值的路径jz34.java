package com.boshrong.leetcode.树;

import com.boshrong.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 输出二叉树中和为特定值的路径jz34 {

    public int count=0;
    public void dfs(TreeNode root,int target,List<Integer> list,List<List<Integer>> result){

        if(root==null){
            return;
        }

        int val=root.val;
        count+=val;
        list.add(val);

        if(root.left==null && root.right==null){
            //为叶子节点
            if(count==target){
                result.add(new ArrayList<>(list));
            }
        }

        dfs(root.left,target,list,result);
        dfs(root.right,target,list,result);
        count-=val;
        int lens=list.size();
        list.remove(lens-1);

    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        //存储中间结果
        ArrayList<Integer> list= new ArrayList<>();
        dfs(root,target,list,result);
        return result;
    }
}
