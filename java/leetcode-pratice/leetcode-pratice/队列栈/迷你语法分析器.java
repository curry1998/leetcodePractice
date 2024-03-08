package com.boshrong.leetcode.队列栈;

import java.util.ArrayDeque;
import java.util.List;

public class 迷你语法分析器 {
//    public NestedInteger deserialize(String s) {
//        // 使用栈，双指针
//        // 直接是一个数字, 返回一个 NestedInteger
//        //
//        int n = s.length();
//        if(!s.startsWith("[")){
//            //直接返回一个整数嵌套列表
//            return new NestedInteger(Integer.valueOf(s));
//        }
//        // 用一个栈保存结果
//        ArrayDeque<NestedInteger> stack=new ArrayDeque<>();
//        // 总的嵌套对象
//        NestedInteger res = new NestedInteger();
//        stack.push(res);
//        int left = 1, right = 1;
//        for(;right<s.length();right++){
//            char ch = s.charAt(right);
//            if(ch == '['){
//                // 需要一个NestedInteger, 更新left
//                NestedInteger tmp = new NestedInteger();
//                left = right+1;
//                stack.peek().add(tmp);
//                stack.push(tmp);
//            }else if(ch == ']' || ch == ','){
//                //一个结束
//                if(left<right){
//                    Integer val = Integer.valueOf(s.substring(left,right));
//                    stack.peek().add(new NestedInteger(val));
//                }
//                left = right+1;
//                if(ch == ']'){
//                    stack.pop();
//                }
//            }
//        }
//        return res;
//    }
}



