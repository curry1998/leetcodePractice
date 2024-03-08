package com.boshrong.leetcode.字符串;

public class 外观数列 {
    public static void main(String[] args) {

    }

    public String countAndSay(int n) {
        // 不断地去更新res
        String res="1";
        for(int i=1;i<n;i++){
            String t="";
            for(int j=0;j<res.length();){
                int k=j;
                while(k<res.length() && res.charAt(k)==res.charAt(j)){
                    k++;
                }
                t+=(k-j);
                t+=res.charAt(j);
                j=k;
            }
            res=t;
        }
        return res;
    }
}
