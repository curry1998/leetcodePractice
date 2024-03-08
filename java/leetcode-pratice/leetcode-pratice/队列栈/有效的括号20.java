package com.boshrong.leetcode.队列栈;

import java.util.ArrayDeque;
import java.util.Stack;

public class 有效的括号20 {

    public static void main(String[] args) {
        System.out.println(isValid("(){}}{"));
    }

    public static boolean isValid(String s) {
        int lens=s.length();
        if(lens<2){
            return false;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        stack.push(s.charAt(0));
        int i=1;
        while(i<lens){

            if(s.charAt(i)=='(' ||s.charAt(i)=='{'|| s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }
            if(s.charAt(i)==')' ||s.charAt(i)=='}'|| s.charAt(i)==']'){
                if(stack.isEmpty()){
                    return false;
                }
                char currentChar =stack.peek();
                if(s.charAt(i)==')'&& currentChar=='(' || s.charAt(i)=='}'&& currentChar=='{'||  s.charAt(i)==']'&& currentChar=='['){
                    stack.pop();
                }else{
                    return false;
                }
            }
            i++;

        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
