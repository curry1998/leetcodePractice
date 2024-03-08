package com.boshrong.leetcode.数学;

public class 罗马数字转整数13 {

    public static void main(String[] args) {

        System.out.println(romanToInt("DCXXI"));
    }
    // 遍历即可，特殊情况进行处理
    public static  int romanToInt(String s) {
        int lens=s.length();
        if(lens<1){
            return 0;
        }
        String [] strings=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int [] nums=new int []{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int result=0;
        int i=0;
        int k=0;
        while(i<lens){

            int stringlen=strings[k].length();
            if (i+stringlen>lens){
                k++;
                continue;
            }
            if(s.substring(i,i+stringlen).equals(strings[k])){
                result+=nums[k];
                i+=stringlen;
            }else{
                k++;
            }
        }
        return result;
    }
}
