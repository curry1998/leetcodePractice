package com.boshrong.leetcode.队列栈;

import org.apache.logging.log4j.util.Strings;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class 字符串解码394 {
    public static void main(String[] args) {
        decodeString("3[a]2[bc]");
    }
    public  static String decodeString(String s) {
        // 思路: 字符串+ 栈进行模拟
        StringBuilder res = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
        int i = 0;
        for(;i<s.length();i++){
            if('0' <= s.charAt(i) && s.charAt(i)<='9'){
                int t = i+1;
                while(t<s.length() && '0'<=s.charAt(t) && s.charAt(t)<='9'){
                    t++;
                }
                stack.push(s.substring(i,t));
                i = t-1;
                continue;
            }
            if(s.charAt(i) == '[' || s.charAt(i)>='a' && s.charAt(i)<= 'z'){
                stack.push(String.valueOf(s.charAt(i)));
                continue;
            }
            if(s.charAt(i)==']'){
                StringBuilder tmp = new StringBuilder();
                while(!stack.isEmpty() && !stack.getFirst().equals("[")){
                    tmp.append(stack.pop());
                }
                if(!stack.isEmpty()){
                    stack.pop();
                }
                int num=0;
                if(!stack.isEmpty()){
                    num =Integer.valueOf(stack.pop());
                }
                tmp.reverse();
                tmp.append(res);
                res = new StringBuilder();
                // 解决了嵌套就解决不了不嵌套
                for(int j=0; j<num;j++){
                    res.append(tmp);
                }
            }
        }
        return res.toString();
    }
}
