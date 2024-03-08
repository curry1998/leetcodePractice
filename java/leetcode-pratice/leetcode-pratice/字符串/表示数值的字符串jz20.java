package com.boshrong.leetcode.字符串;

public class 表示数值的字符串jz20 {

    public static void main(String[] args) {
        isNumber("4e+");
    }

    public static boolean isPurfyNumber2(String str){
        int lens=str.length();
        // 有时候需要空格
        if(lens==0){
            return false;
        }
        for(int i=0;i<lens;i++){
            if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    // 判断是否为纯整数 正常数单独写一个函数
    public static boolean isPurfyNumber(String str){
        int lens=str.length();
        // 有时候需要空格
        if(lens==0){
            return true;
        }
        for(int i=0;i<lens;i++){
            if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    public static boolean isNoralNumber(String str){

        //判断有没有. 是否为小数
        if(str.indexOf('.')!=-1 ){
            String first=str.substring(0,str.indexOf('.'));
            String second=str.substring(str.indexOf('.')+1,str.length());
            // 匹配该规则
            //3.1 至少一位数字，后面跟着一个点 '.'
            //3.2 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
            if(second.equals("") && first.equals("") ){
                return false;
            }
            if (first.equals("")){
                return isPurfyNumber(second);
            }
            return isPurfyNumber(first)&&isPurfyNumber(second);
        }else{
            return isPurfyNumber(str);
        }
    }

    public static boolean isNumber(String str) {
        // 去掉空格
        str=str.trim();
        int lens=str.length();
        if(lens<1){
            return false;
        }
        //如果有 + - 符号 去掉
        if(str.charAt(0)=='+' || str.charAt(0)=='-'){
            str=str.substring(1,lens);
        }
        if(str.equals("")){
            return false;
        }
        if(str.indexOf('E')!=-1|| str.indexOf('e')!=-1){
            // 包含 e 或E ,用e 替换 E
            str=str.replace('E','e');
            String first=str.substring(0,str.indexOf('e'));
            String last =str.substring(str.indexOf('e')+1,str.length());
            // 在这里就进行操作，为了isPurfyNumber 更好的通过
            if(last.equals("") || first.equals("")){
                return false;
            }
            if(last.charAt(0)=='+' || last.charAt(0)=='-'){
                last=last.substring(1,last.length());
            }
            return isNoralNumber(first) && isPurfyNumber2(last);
        }else{
            //没有e 直接判断是否为正常数
            return isNoralNumber(str);
        }

    }

}
