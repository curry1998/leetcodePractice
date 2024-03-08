package com.boshrong.leetcode.微软面试;

public class 字符串相乘43 {
    public String multiply(String num1, String num2) {
        int len1=num1.length();
        int len2=num2.length();
        if(len1==0 || len2==0){
            return null;
        }
        int [] temp=new int[len1+len2];
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                temp[len1-i+len2-j-2]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        // 进行进位
        int t=0;
        for(int i=0;i<temp.length;i++){
            t+=temp[i];
            temp[i]=t%10;
            t/=10;
        }
        //处理结果，乘积变为字符串,高位可能为0
        String res="";
        int k=temp.length-1;
        while(k>0&&temp[k]==0){
            k--;
        }
        for(int i=k;i>=0;i--){
            res+=Integer.toString(temp[i]);
        }
        return res;
    }
}
