package com.boshrong.leetcode.树;

public class 二叉搜索树的后序遍历序列33 {

    public static void main(String[] args) {
        int [] nums=new int[]{1,2,7,4,6,5,3};
        System.out.println(verifyPostorder(nums));
    }

    static boolean  dfs(int l,int r,int [] postorder){
        if(l>=r){
            return true;
        }
        int root=postorder[r];
        int k=l;
        // 找到一个孩子
        while(k<=r && postorder[k]<root ){
            k++;
        }

        for(int i=k;i<r;i++){
            if(postorder[i]<root){
                return false;
            }
        }

        return  dfs(l,k-1,postorder) && dfs(k,r-1,postorder);
    }

    public static  boolean verifyPostorder(int[] postorder) {
        int lens=postorder.length;
        if(lens<1){
            return false;
        }
        boolean flag=dfs(0,lens-1,postorder);
        return flag;
    }
}
