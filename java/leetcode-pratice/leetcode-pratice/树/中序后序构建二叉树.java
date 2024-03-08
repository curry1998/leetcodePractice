package com.boshrong.leetcode.树;

import java.util.HashMap;

public class 中序后序构建二叉树 {
    HashMap<Integer,Integer> hashMap;
    int [] inorder;
    int [] postorder;


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        hashMap=new HashMap<>();
        for(int i=0;i<n;i++){
            hashMap.put(inorder[i],i);
        }
        this.inorder=inorder;
        this.postorder=postorder;
        TreeNode root=dfs(0,n-1,0,n-1);
        return root;
    }
    public TreeNode dfs(int ix,int iy,int px,int py){
        if(ix>iy){
            return null;
        }


        int k=hashMap.get(postorder[py]);
        TreeNode node=new TreeNode(postorder[py]);

        int lens=k-ix;
        node.left=dfs(ix,k-1,px,px+lens-1);
        node.right=dfs(k+1,iy,px+lens,py-1);
        return node;
    }
}
