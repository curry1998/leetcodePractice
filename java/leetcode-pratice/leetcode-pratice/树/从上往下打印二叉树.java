package com.boshrong.leetcode.树;



import com.boshrong.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 从上往下打印二叉树 {
}

//class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//
//    }
//
//}

class Solution8 {

    public static void main(String[] args) {

    }

    ArrayList<Integer> res=new ArrayList<>();
    Queue<TreeNode> queue=new LinkedList<>();
    public int [] PrintFromTopToBottom(TreeNode root) {
        if(root==null){
            //list 转为aarray
            int[] arr= res.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
            return arr;
        }

        queue.add(root);
        //类似先序遍历
        while(queue.size()>0){
            TreeNode treeNode=queue.peek();
            queue.remove();
            if(treeNode.left!=null){
                queue.add(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.add(treeNode.right);
            }
            res.add(treeNode.val);
        }
        int[] arr= res.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return arr;
    }

}
