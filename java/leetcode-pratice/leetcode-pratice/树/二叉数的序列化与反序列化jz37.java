package com.boshrong.leetcode.树;

import com.boshrong.leetcode.TreeNode;

import java.util.LinkedList;

public class 二叉数的序列化与反序列化jz37 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
//        TreeNode treeNode2 = new TreeNode(3);
//        TreeNode treeNode3 = new TreeNode(4);
//        TreeNode treeNode4 = new TreeNode(5);
        treeNode.right=treeNode1;
//        treeNode.right=treeNode2;
//        treeNode1.left=null;
//        treeNode1.right=null;
//        treeNode2.left=treeNode3;
//        treeNode2.right=treeNode4;
//        treeNode3.left=null;
//        treeNode3.right=null;
//        treeNode4.left=null;
//        treeNode4.right=null;
        String ss=Serialize(treeNode);
        System.out.println(ss);
        Deserialize(ss);
    }

    //层序遍历， 遇到空进行特殊处理,感觉自己水平序列化麻烦了，应该先序来进行序列化的
    static  String Serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        String result="";
        //双端队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            //
            if(poll.val==Integer.MIN_VALUE) {
                result += "$,"; // 用$表示这里为null,每个元素用, 进行区分
            } else{
                result+=poll.val+",";
            }

            if(poll.left!=null)
                queue.add(poll.left);
            // 产生一个空结点,用Integer.MinValue 表示为空
            if(poll.left==null && poll.val!=Integer.MIN_VALUE) {
                TreeNode leftTreeNode = new TreeNode(Integer.MIN_VALUE);
                queue.add(leftTreeNode);
            }
            if(poll.right!=null)
                queue.add(poll.right);

            // 产生一个空结点,用Integer.MinValue 表示为空

            // 要保证poll 在进行下面判断的时候不为空
            if(poll.right==null && poll.val!=Integer.MIN_VALUE){
                    TreeNode rightTreeNode=new TreeNode(Integer.MIN_VALUE);
                    queue.add(rightTreeNode);
                }
            }

        int lens=result.length();
        int idx=lens-1;
        while(result.charAt(idx)=='$'||result.charAt(idx)==','){
            idx--;
        }

        return result.substring(0,idx+1);
    }

    static TreeNode Deserialize(String str) {
        //str  水平遍历 str 为$ 代表着空
        if(str == null || str.length() == 0)  return null;

        String[] split = str.split(",");
        LinkedList<TreeNode> queue = new LinkedList<>();
        int lens=split.length;
        // 之前用queue 了，这里也要用queue
        // 利用水平遍历的结果将str 组成为一颗二叉树
        TreeNode headtNode = new TreeNode(Integer.parseInt(split[0]));
        queue.add(headtNode);
          int idx=1;
        while(!queue.isEmpty() && idx<lens){
            TreeNode t = queue.poll();
            if(!"$".equals(split[idx])){
                t.left = new TreeNode(Integer.parseInt(split[idx]));
                queue.add(t.left);
            }
            idx++;
            if(idx<lens&&!"$".equals(split[idx])){
                t.right = new TreeNode(Integer.parseInt(split[idx]));
                queue.add(t.right);
            }
            idx++;
        }
        return headtNode;
    }
}
