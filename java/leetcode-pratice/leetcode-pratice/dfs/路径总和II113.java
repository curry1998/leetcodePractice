package com.boshrong.leetcode.dfs;



import com.boshrong.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 路径总和II113 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1=new TreeNode(4);
        TreeNode treeNode2=new TreeNode(8);
        TreeNode treeNode3 = new TreeNode(11);
        TreeNode treeNode4 = new TreeNode(13);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(2);
        TreeNode treeNode8 = new TreeNode(5);
        TreeNode treeNode9 = new TreeNode(1);
        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.left=treeNode3;
        treeNode1.right=null;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        treeNode3.left=treeNode6;
        treeNode3.right=treeNode7;
        treeNode4.left=null;
        treeNode4.right=null;
        treeNode5.left=treeNode8;
        treeNode5.right=treeNode9;
        treeNode6.left=null;
        treeNode6.right=null;
        treeNode7.left=null;
        treeNode7.right=null;
        treeNode8.left=null;
        treeNode8.right=null;
        treeNode9.left=null;
        treeNode9.right=null;
        pathSum(treeNode,22);

    }
    //注意因为tmp.add 是存放结果之前，所以构造结果那里也要 tmp.remove(tmp.size()-1);
    static List<List<Integer>> res;
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        if(root == null){
            return res;
        }
        List<Integer> tmp = new ArrayList<>();
        dfs(root, tmp, targetSum);
        return res;
    }
    public static void dfs(TreeNode root, List<Integer> tmp, int targetSum){
        if(root == null){
            return ;
        }
        tmp.add(root.val);
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0){
            res.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size()-1);
            return ;
        }

        dfs(root.left, tmp, targetSum);
        dfs(root.right, tmp,targetSum);
        tmp.remove(tmp.size()-1);
    }

}
