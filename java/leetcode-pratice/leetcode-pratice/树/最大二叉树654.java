package com.boshrong.leetcode.树;

public class 最大二叉树654 {
    // 类似与重建二叉树，找到一个给定范围的 nums 的最大值，当作根节点去构造二叉树
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        return build(nums,0,n-1);
    }
    public TreeNode build(int [] nums , int s, int e ){
        if(s>e){
            return null;
        }
        int idx = getMaxIndex(nums,s,e);
        TreeNode node = new TreeNode(nums[idx]);
        node.left = build(nums, s ,idx-1);
        node.right = build(nums, idx+1 ,e);
        return node;

    }
    public int getMaxIndex (int [] nums,int s, int e){
        int res = Integer.MIN_VALUE;
        int idx = s;
        for(int i = s; i <= e; i++){
            if(nums[i]>res){
                res = nums[i];
                idx = i;
            }
        }
        return idx;
    }
}
