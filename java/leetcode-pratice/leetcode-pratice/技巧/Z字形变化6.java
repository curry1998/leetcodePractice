package com.boshrong.leetcode.技巧;

import java.util.ArrayList;
import java.util.LinkedList;

public class Z字形变化6 {
    // 思想：定义一个字符串数组 根据给定的numrows,将相同行的字符加到同一个字符串中
    public static void main(String[] args) {
        System.out.println(convert("AB",1));

        // String 数组默认值为null 再使用+ 就会还带null

    }

    public  static  String convert(String s, int numRows) {
        int lens=s.length();
        if(lens<2|| numRows==1){
            return s;
        }

        int nums=0;
        //可以用num 判断出数组的长度 直接用数组
        String [] result=new String[numRows];
        for(int i=0;i<numRows;i++){
            result[i]="";
        }

        //定义一个变量来确定 方向，像下走还是向上走
        boolean goDown=true;
        for(int i=0;i<lens;i++){
            if(nums!=numRows-1 && goDown){
                result[nums]+=s.charAt(i);
                nums++;
                continue;
            }
            if(nums==numRows-1 && goDown){
                result[nums]+=s.charAt(i);
                goDown=false;
                nums--;
                continue;
            }
            if(nums!=0&& !goDown){
                result[nums]+=s.charAt(i);
                nums--;
                continue;
            }
            if(nums==0 && !goDown){
                result[nums]+=s.charAt(i);
                nums++;
                goDown=true;
                continue;
            }
        }

        String result_String="";
        for(int i=0;i<numRows;i++){
            result_String+=result[i];
        }
        return result_String;
    }
}
