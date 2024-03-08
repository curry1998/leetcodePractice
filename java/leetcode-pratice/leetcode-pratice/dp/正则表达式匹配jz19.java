package com.boshrong.leetcode.dp;

public class 正则表达式匹配jz19 {
    public static void main(String[] args) {
       match("a","ab*a");
    }

    public static boolean match (String str, String pattern) {
        // 感觉使用递归更为方便一些
        // 两个都为空返回true
        int len1 = str.length();
        int len2 = pattern.length();
        if (len1 == 0 && len2 == 0|| (len1==0 && len2==2 && pattern.charAt(1)=='*')) {
            return true;
        }
        //str不为空,pattern为空返回false
        if (len1 != 0 && len2 == 0) {
            return false;
        }
        if (len2 >=2) {
            if (pattern.charAt(1) != '*') {
                //直接进行匹配
                if (str.charAt(0) == pattern.charAt(0) || len1 != 0 && pattern.charAt(0) == '.') {
                    return match(str.substring(1, len1), pattern.substring(1, len2));
                } else {
                    return false;
                }
            } else {
                //当前匹配上了*
                if (str.charAt(0) == pattern.charAt(0) || len1 != 0 && pattern.charAt(0) == '.') {
                    //前面的表示匹配0个 解决(a,a*a),后面表示匹配多个
                    return match(str.substring(0, len1), pattern.substring(2, len2)) || match(str.substring(1, len1), pattern.substring(0, len2));
                } else {
                    //不匹配，则表示前面匹配0个
                    return match(str.substring(0, len1), pattern.substring(2, len2));
                }
            }
        }
        else{
            if(len1==0){
                return false;
            }
            if (str.charAt(0) == pattern.charAt(0) || len1 != 0 && pattern.charAt(0) == '.') {
                return match(str.substring(1, len1), pattern.substring(1, len2));
            } else {
                return false;
            }
        }

    }

}
