package com.boshrong.leetcode.树;

import com.boshrong.leetcode.TreeNode;
import lombok.val;

import java.util.*;

public class 在二叉树中找到两个节点的最近公共祖先jz68 {

    int result=0;
    //判断左右孩子是否有p,g节点
    public boolean dfs(TreeNode root,int o1,int o2){
        if(root==null){
            return false;
        }
        Boolean left=dfs(root.left,o1,o2);
        Boolean right=dfs(root.right,o1,o2);
        //判断当前节点是否满足最近祖先
        //p,q 节点分别在其左右孩子，则一定为最近祖先。
        //当前节点为p,或q 并且另外一个节点在器左右孩子中
        if((left&&right)||(root.val==o1 ||root.val==o2)&&(left||right)){
            result=root.val;
        }
        //返回判断的结果

        return left||right||(root.val==o1)||(root.val==o2);
    }

    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        dfs(root,o1,o2);
        return result;
    }
}
