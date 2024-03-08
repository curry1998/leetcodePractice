package com.boshrong.leetcode.队列栈;

import java.util.ArrayDeque;

public class 简化路径71栈 {

    public static void main(String[] args) {

    }
    public String simplifyPath(String path) {
        // 使用栈进行模拟， 将字符串按照/ 进行切分，切分后将满足条件的入栈
        // 遇到 .. 判断栈是否为空，不为空，出栈
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        String [] words = path.split("/");
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(".") || words[i].equals("")){
                continue;
            }
            if(words[i].equals("..")){
                if(!stack.isEmpty()){
                    stack.poll();
                }
            }else{
                stack.push(words[i]);
            }
        }
        while(!stack.isEmpty()){
            res.append(stack.getLast());
            res.append("/");
            stack.removeLast();
        }
        if(res.length() > 1 && res.charAt(res.length()-1) == '/'){
            res.delete(res.length()-1,res.length());
        }
        res.insert(0,"/");
        return res.toString();
    }
}
