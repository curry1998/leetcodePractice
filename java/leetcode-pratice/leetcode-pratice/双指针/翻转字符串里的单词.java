package com.boshrong.leetcode.双指针;

public class 翻转字符串里的单词 {

    public static void main(String[] args) {
        //判断依据找到了
        //        String ss=" Bob  Loves  Alice";
//        String substring = ss.substring(1, 2);
//        System.out.println(substring.isEmpty());
        System.out.println(reverseWords(" Bob  Loves  Alice"));
    }
    public static String reverseWords(String s) {
        int lens=s.length();
        if(lens<1){
            return s;
        }
        int i=lens-1,j=lens-1;
        String result="";
        boolean flag=false;
       while(i>=0){
            if(s.charAt(i)==' '){
                if(!s.substring(i+1,j+1).isEmpty()){
                    String s2=s.substring(i+1,j+1);

                    result+=s2;
                    result+=" ";
                    j=i;

                }
                j--;
                i--;

            }else{
                i--;

            }
            // 处理最前面没有空格的情况
            if(i==0 && s.charAt(i)!=' ' ){
                result+=s.substring(i,j+1);
                flag=true;
            }

        }
       if(flag){
           return result;
       }else{
           int len=result.length();
           return result.substring(0,len-1);
       }

    }
}
