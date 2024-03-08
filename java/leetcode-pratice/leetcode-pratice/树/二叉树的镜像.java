package com.boshrong.leetcode.树;

import com.boshrong.leetcode.TreeNode;

public class 二叉树的镜像 {
}




  class Solution {
      /**
       * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
       *
       * @param pRoot TreeNode类
       * @return TreeNode类
       */
      // 利用递归思想从下向上交换
      public TreeNode Mirror(TreeNode pRoot) {
          if(pRoot==null){
              return null;
          }
          TreeNode treeNode = new TreeNode(pRoot.val);
          treeNode.right = Mirror(pRoot.left);
          treeNode.left = Mirror(pRoot.right);
          pRoot=treeNode;
          return pRoot;
      }

  }


