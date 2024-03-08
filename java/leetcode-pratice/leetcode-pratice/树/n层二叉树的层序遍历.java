package com.boshrong.leetcode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class n层二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node2 root) {
        // 层序遍历
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<Node2> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){

            int t = queue.size();
            List<Integer> tmpRes= new ArrayList<>();
            for(int i =0;i<t;i++){

                Node2 tmp = queue.poll();
                tmpRes.add(tmp.val);
                int n = tmp.children.size();
                for(int j=0;j<n;j++){
                    if(tmp.children.get(j)!=null){
                        queue.offer(tmp.children.get(j));
                    }
                }
            }
            res.add(tmpRes);
        }
        return res;
    }
}

 //Definition for a Node.
class Node2 {
    public int val;
    public List<Node2> children;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val, List<Node2> _children) {
        val = _val;
        children = _children;
    }
};
