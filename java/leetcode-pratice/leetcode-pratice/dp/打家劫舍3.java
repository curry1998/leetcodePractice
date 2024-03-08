package com.boshrong.leetcode.dp;

import com.boshrong.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

public class 打家劫舍3 {
    HashMap<TreeNode,Integer> f=new HashMap<>();
    HashMap<TreeNode,Integer> g=new HashMap<>();
    public int rob(TreeNode root) {
        // 思路: 动态规划 ,遍历过程是一个树,先先序遍历获取到一个数组
        //  树的节点在 1~10^4 ，高度为101
        // 会出现虽然相邻，但不相连的情况。 是否选择节点，是一个重要的指标
        // f(o) 选择节点o,所能盗取的最大金额。
        // g(o)  不选择节点o,所能盗取的最大金额。
        // 设 l,r 分别为其左右孩子，状态转移方程: f[o]=max(g[o.left],g[o.right])+o.val
        // g[o]=max(f[l],f[r],f[l]+f[r],g[l]+g[r]) 四中情况
        dfs(root);
        // 返回的是root 节点的最大金额，最好使用hashmap
        return  Math.max(f.get(root),g.get(root));

    }
    public TreeNode dfs(TreeNode root){
        // 先序遍历
        if(root==null){
            return null;
        }
        TreeNode left=dfs(root.left);
        TreeNode right=dfs(root.right);
        f.put(root,Math.max(g.getOrDefault(left,0),g.getOrDefault(right,0))+root.val);
        int val=Math.max(f.getOrDefault(left,0),f.getOrDefault(right,0));
        int val2=Math.max(val,f.getOrDefault(left,0)+f.getOrDefault(right,0));
        g.put(root,Math.max(val2,g.getOrDefault(left,0)+g.getOrDefault(right,0)));
        return root;
    }
}
