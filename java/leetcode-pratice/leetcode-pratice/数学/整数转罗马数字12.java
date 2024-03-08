package com.boshrong.leetcode.数学;

import java.util.HashMap;

public class 整数转罗马数字12 {

    public static void main(String[] args) {
        System.out.println(intToRoman(1994 ));
    }

    public  static String intToRoman(int num) {
        if(num<1){
            return null;
        }
        String [] strings=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int [] nums=new int []{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String result="";
        int i=0;
        while(num!=0){
            if(num-nums[i]<0){
                i++;
                continue;
            }
            num-=nums[i];
            result+=strings[i];

        }

        return result;

    }
}
