package com.boshrong.leetcode.树;

public class 删除二叉搜索树中的节点450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        // 是二叉搜索树，先序遍历 判断

        // 找到删除的节点，如果左孩子，右孩子都为空，直接返回一个null
        // 左孩子为空，右孩子不为空，删除节点，返回一个右孩子。
        // 右孩子为空，左孩子不为空，删除节点，返回左孩子。
        // 左右孩子都不为空， 则将左孩子放到到右孩子最左边的孩子的左孩子，返回右孩子。

        if(root == null){
            return null;
        }

        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else if (root.val == key){
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else {
                TreeNode tmp = root.right;
                while(tmp.left != null){
                    tmp = tmp.left;
                }
                tmp.left = root.left;
                return root.right;
            }
        }
        return root;
    }
}
