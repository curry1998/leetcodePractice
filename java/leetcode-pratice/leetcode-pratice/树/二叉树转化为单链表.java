package com.boshrong.leetcode.树;


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val=val;
    }

}

public class 二叉树转化为单链表 {
    public static void main(String[] args) {

    }
    public void flatten(TreeNode root) {
        TreeNode current=root;
        while(current!=null){
            if(current.left!=null){
                TreeNode work=current.left;
                TreeNode workright=work;
                while(workright.right!=null){

                    workright=workright.right;
                }
                workright.right=current.right;
                current.right=work;
                current.left=null;
            }
            current=current.right;
        }
    }
}
