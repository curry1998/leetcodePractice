package com.boshrong.leetcode.技巧;

public class 把字符串转化为整数jz67 {
    //82

    public static void main(String[] args) {
        StrToInt("--12");

    }

    public static int StrToInt (String s) {
        // write code here
        int lens=s.length();
        if(lens<1){
            return 0;
        }

        int start=0;
        Boolean isMinus=false;
        int midResult=0;
        for(int i=0;i<lens;i++){
            if(s.charAt(i)==' ')
                continue;
            if(s.charAt(i)=='-'){
                start=i+1;
                isMinus=true;
                break;
            }
            if(s.charAt(i)=='+'){
                start=i+1;
                break;
            }
            if(s.charAt(i)>='0'&& s.charAt(i)<='9'){
                start=i;
                break;
            }
            if(s.charAt(i)>='A'&& s.charAt(i)<='Z'||s.charAt(i)>='a' && s.charAt(i)<='z'){
                return 0;
            }
        }
        //有个溢出判断
        for(int i=start;i<lens;i++){
            if(s.charAt(i)>='0'&& s.charAt(i)<='9'){
                int temp=midResult;
                midResult=midResult*10+(s.charAt(i)-'0');

                if(midResult/10!=temp){
                    //溢出
                    if(!isMinus){
                        midResult=Integer.MAX_VALUE;
                    }else{
                        midResult=Integer.MIN_VALUE;
                    }
                    return midResult;
                }

            }else{
                break;
            }
        }

        if(isMinus){
            midResult=-midResult;
        }
        return midResult;
    }
}
