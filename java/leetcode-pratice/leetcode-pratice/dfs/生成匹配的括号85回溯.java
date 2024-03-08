package com.boshrong.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class 生成匹配的括号85回溯 {

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(2);
        for (String s:strings){
            System.out.println(s);
        }
    }

    // 定义一个dfs 函数
    public  static void  dfs (int left,int right,String tmp,List<String> resultList){
        //到达边界状态进行赋值
        if(left==0 && right==0 ){
            resultList.add(tmp);
            return;
        }
        //右边剩余括号right 要严格大于left. 不满足进行剪支
        //如果两个中有一个小于0,表示用完了还要用 ，不能产生分支
        if(right<left||right<0||left<0){
            return;
        }
        //可以产生分支，进行下面操作

        //产生一个左括号分支,在这里进行了一次更新
        dfs(left-1,right,tmp+"(",resultList);
        //产生一个右括号分支
        dfs(left,right-1,tmp+")",resultList);

    }

    public  static  List<String> generateParenthesis(int n) {

        ArrayList<String> result = new ArrayList<>();
        dfs(n,n,"",result);
        return result;
    }
}
