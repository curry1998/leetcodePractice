package com.boshrong.leetcode.dfs;

import java.util.Arrays;
import java.util.Comparator;

public class 火柴拼正方形 {
    public boolean makesquare(int[] matchsticks) {
        //思路: 每个边的长度为总和除以4，先搜索第一条边，能否凑出第一条边，凑出第一条边，所有用过的火柴打个标记。
        //再去搜第二条，第三条，如果能凑出前三条边，就不用再凑了。
        // 1 从大到小去枚举火柴，可以很快去减枝。
        // 2 每条边内部，要求火柴编号递增。
        // 3 若当前放某根火柴失败  1 跳过长度相同的火柴 2 如果是某条边第一根火柴 3 如果是最后一个也直接剪掉当前分支。

        int lens=matchsticks.length;
        int total=0;
        for(int i=0;i<lens;i++){
            total+=matchsticks[i];
        }
        if(total%4!=0){
            return false;
        }
        Integer[] array=new Integer[matchsticks.length];
        for (int i = 0; i < matchsticks.length; i++) {
            array[i]=matchsticks[i];
        }
        // 从大到小 o2-o1
        Arrays.sort(array,(a,b)->
              b-a
        );
        boolean[] visited=new boolean [lens];
        for(int i=0;i<4;i++){
            // dfs(matchsticks,visited,total/4);
        }
        return true;
    }
}
