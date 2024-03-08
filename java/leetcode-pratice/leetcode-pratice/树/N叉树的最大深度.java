package com.boshrong.leetcode.树;

public class N叉树的最大深度 {
    public int maxDepth(Node2 root) {
        if(root==null){
            return 0;
        }
        int currentLens =0;
        for(int i=0;i<root.children.size();i++){
            int l = maxDepth(root.children.get(i));
            if(l>currentLens){
                currentLens =l;
            }
        }

        return currentLens+1;
    }
}
