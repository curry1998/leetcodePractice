package com.boshrong.leetcode.微软面试;

public class 二十六进制向字符串转化 {
    public static void main(String[] args) {
        char s=2+'A'; //可以得到C
        System.out.println(s);
        solve(75);
    }


    public static String solve(int num){
         if(num<=0){
             return null;
         }
         String res="";
         int value=1;
         while(num!=0){
             //num 对value 求余得到各位
             value*=26;
             int s=num%value;
             res+=(char)(s+'A'-1);
             num/=value;
             if(num<26){
                 res+=(char)(num+'A'-1);
                 break;
             }
         }
         return new StringBuffer(res).reverse().toString();
    }
}
