package com.boshrong.leetcode.树;

public class 将有序数组转换为二叉搜索树108 {
    public TreeNode sortedArrayToBST(int[] nums) {

        int lens=nums.length;
        TreeNode root=dfs(nums,0,lens-1);
        return root;

    }
    public TreeNode dfs(int []nums,int l, int r){
        if(l>r){
            return null;
        }
        int mid=(l+r+1)/2;
        TreeNode head=new TreeNode(nums[mid]);
        head.left=dfs(nums,l,mid-1);
        head.right=dfs(nums,mid+1,r);
        return head;

    }
}
