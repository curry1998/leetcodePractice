package com.boshrong.leetcode.树;

public class 二叉搜索树与双向链表jz36 {

    Node pre,head;
    public void dfs(Node root){
        if(root==null){
            return ;
        }
        dfs(root.left);

        if(pre!=null){
            root.left=pre;
            pre.right=root;
            pre=root;
        }else{
            pre=root;
            head=root;
        }

        dfs(root.right);
    }

    public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }
        dfs(root);
        //最后进行处理
        head.left=pre;
        pre.right=head;
        return head;
    }
}


 class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
