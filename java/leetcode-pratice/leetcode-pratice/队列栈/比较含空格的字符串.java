package com.boshrong.leetcode.队列栈;

public class 比较含空格的字符串 {
    public boolean backspaceCompare(String s, String t) {
        char [] swords = s.toCharArray();
        char [] twords = t.toCharArray();
        String s1 ="";
        String s2 ="";
        for(int i =0;i<swords.length;i++){
            if(swords[i]=='#'){
                if(s1.length()>=2){
                    s1 = s1.substring(0,s1.length()-1);
                }else{
                    s1 = "";
                }
                continue;
            }
            s1+=String.valueOf(swords[i]);
        }
        for(int i =0;i<twords.length;i++){
            if(twords[i]=='#'){
                if(s2.length()>=2){
                    s2 = s2.substring(0,s2.length()-1);
                }else{
                    s2 = "";
                }
                continue;
            }
            s2+=String.valueOf(twords[i]);
        }
        System.out.println(s1);
        System.out.println(s2);
        return s1.equals(s2);
    }
}
