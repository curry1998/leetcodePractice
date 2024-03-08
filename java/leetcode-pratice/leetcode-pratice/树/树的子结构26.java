package com.boshrong.leetcode.树;

import com.boshrong.leetcode.TreeNode;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

public class 树的子结构26 {
    public static void main(String[] args) {
        com.boshrong.leetcode.TreeNode treeNode = new com.boshrong.leetcode.TreeNode(3);
        com.boshrong.leetcode.TreeNode treeNode1=new com.boshrong.leetcode.TreeNode(4);
        com.boshrong.leetcode.TreeNode treeNode2=new com.boshrong.leetcode.TreeNode(5);
        com.boshrong.leetcode.TreeNode treeNode3 = new com.boshrong.leetcode.TreeNode(1);
        com.boshrong.leetcode.TreeNode treeNode4 = new com.boshrong.leetcode.TreeNode(2);
        com.boshrong.leetcode.TreeNode treeNode5 = new com.boshrong.leetcode.TreeNode(4);
        com.boshrong.leetcode.TreeNode treeNode6 = new com.boshrong.leetcode.TreeNode(1);

        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.left=treeNode3;
        treeNode1.right=treeNode4;
        treeNode2.left=null;
        treeNode2.right=null;
        treeNode3.left=null;
        treeNode3.right=null;
        treeNode4.left=null;
        treeNode4.right=null;

        treeNode5.left=treeNode6;
        treeNode5.right=null;
        treeNode6.left=null;
        treeNode6.right=null;
        System.out.println(isSubStructure(treeNode,treeNode5));


    }


    public static void dfs(TreeNode A,TreeNode B,ArrayList<Boolean> list){
        // 找第一个节点

        if(A==null ){
            return ;
        }
        boolean flag=dfs2(A,B);
        list.add(flag);
        dfs(A.left,B,list);
        dfs(A.right,B,list);

    }
    //判断子结构
    public static Boolean dfs2(TreeNode A,TreeNode B){
        if(B==null){
            return true;
        }
        if(A==null){
            return false;
        }
        if(A.val!=B.val){
            return false;
        }
        Boolean left=dfs2(A.left,B.left);
        Boolean right=dfs2(A.right,B.right);
        return left && right;
    }

    public static  boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null){
            return false;
        }
        ArrayList<Boolean> arrayList = new ArrayList<>();
        dfs(A,B,arrayList);
        int lens=arrayList.size();
        for(int i=0;i<lens;i++){
            if(arrayList.get(i)){
                return true;
            }
        }
        return false;
    }


}


