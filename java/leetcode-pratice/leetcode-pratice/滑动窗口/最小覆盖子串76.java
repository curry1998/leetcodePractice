package com.boshrong.leetcode.滑动窗口;

import java.util.HashMap;

public class 最小覆盖子串76 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.minWindow("a","b"));
    }
}
//
class Solution1 {
    public String minWindow(String s, String t) {
        if(s.length()==0||t.length()==0|| t.length()>s.length())
            return  "";
        int left=0;
        int right=0,flag=0;
        String result;
        HashMap<Character, Integer> needed = new HashMap<>();
        // t.charAt是自己百度得到的
        // 不可能出现重复字符
        //设置满足条件为needed hash 所有vlue 为负则满足匹配条件
        for(int i=0;i<t.length();i++){
                needed.put(t.charAt(i),needed.getOrDefault(t.charAt(i),0)+1);
        }
        String res=s;
        while (right<s.length()){
            if(needed.containsKey(s.charAt(right))){
                //包含在need中need-1
                needed.put(s.charAt(right),needed.getOrDefault(s.charAt(right),0)-1);
            }
            right++;
            //检查条件,如果满足所有value 都不为正的说明，包含t的所有元素
            while(checkCondition(needed)){
                res=getMinString(res,s.substring(left,right));

                if(needed.containsKey(s.charAt(left))){
                    needed.put(s.charAt(left),needed.get(s.charAt(left))+1);
                }
                left++;
                flag=1;
            }

        }
        if(flag==0)
            res="";
        return res;
    }
    public Boolean checkCondition(HashMap<Character,Integer> map){
        for(Integer i:map.values()){
            if(i>0)
                return false;
        }
        return true;
    }
    public String getMinString(String a,String b){
        return a.length()<b.length()? a:b;
    }



}
