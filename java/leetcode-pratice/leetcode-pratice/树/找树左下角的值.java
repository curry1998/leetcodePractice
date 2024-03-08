package com.boshrong.leetcode.树;

import java.util.LinkedList;
import java.util.Queue;

public class 找树左下角的值 {
    public int findBottomLeftValue(TreeNode root) {
        // 直观思路： 获取该二叉树的高度，层序遍历
        if(root == null){
            return 0;
        }
        int depth = getDepth(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i =0;
        while(!queue.isEmpty()){
            int t = queue.size();
            i++;
            if(i==depth){
                return queue.peek().val;
            }
            for(int k = 0;k < t;k++){
                TreeNode tmp = queue.poll();
                if(tmp.left != null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
            }

        }
        return -1;
    }
    public int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right))+1;
    }
}
