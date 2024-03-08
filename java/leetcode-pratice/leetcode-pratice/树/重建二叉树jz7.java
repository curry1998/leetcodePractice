package com.boshrong.leetcode.树;

import com.boshrong.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 重建二叉树jz7 {

    HashMap<Integer,Integer> hashMap=new HashMap<>();
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {

        int preLength=pre.length;
        int inLength=in.length;
        if(preLength!=inLength){
            return null;
        }
        for(int i=0;i<inLength;i++){
            //存储中序遍历中的
            hashMap.put(in[i],i);
        }
        TreeNode head=dfs(pre,in,0,preLength-1,0,inLength-1);
        return head;
    }

    public TreeNode dfs(int [] pre,int [] in,int pl,int pr,int vl,int vr){
        if(pl>pr){
            return null;
        }
        // 获得当前区域前序遍历第一个元素
        int k = hashMap.get(pre[pl]);
        TreeNode treeNode = new TreeNode(pre[pl]);
        TreeNode left=dfs(pre,in,pl+1,pl+k-vl,vl,k-1);
        TreeNode right=dfs(pre,in,pl+k-vl+1,pr,k+1,vr);
        treeNode.left=left;
        treeNode.right=right;
        return treeNode;
    }
}
