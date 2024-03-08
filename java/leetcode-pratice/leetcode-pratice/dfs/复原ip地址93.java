package com.boshrong.leetcode.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 复原ip地址93 {

    // 解题思路:  dfs，每次找一段，这一段的位数为0-3，将满足条件的段加入到中间结果
    public List<String> restoreIpAddresses(String s) {
        int lens = s.length();
        // 存放中间结果
        ArrayDeque<String> tmp =new ArrayDeque<>();
        List<String> res =new ArrayList<>();
        dfs(0,s,tmp,res,0);
        return res;
    }
    // splitTime 表示分割了几次
    public void dfs(int begin, String s, ArrayDeque<String> tmp,List<String> res,int splitTime){
        int lens = s.length();
        if(begin== lens){
            if(splitTime==4){
                res.add(String.join(".",tmp));
            }
            return;
        }
        //  剩下的不够切 或者剩下的太多了
        if(lens-begin<(4-splitTime) || lens-begin> 3*(4-splitTime)){
            return;
        }

        for(int i=0;i<3;i++){
            if(begin+i>=lens){
                return;
            }
            int ipSegment =isCorrectIp(s,begin,begin+i);
            if(ipSegment!=-1){
                // 在判断是 ip 段的情况下，才去做截取
                tmp.addLast(ipSegment + "");
                dfs(begin+i,s,tmp,res,splitTime+1);
                tmp.removeLast();
            }
        }

    }
    // 将字符串切割成整数，不满足返回-1
    public int isCorrectIp(String s,int l,int r){
        int len = r - l+ 1;

        // 大于 1 位的时候，不能以 0 开头
        if (len > 1 && s.charAt(l) == '0') {
            return -1;
        }

        // 转成 int 类型
        int res = 0;
        for (int i = l; i <= r; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }

        if (res > 255) {
            return -1;
        }
        return res;

    }
}
