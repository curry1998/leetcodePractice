package com.boshrong.leetcode.微软面试;

import org.hamcrest.core.Is;

import java.util.Collections;
import java.util.Scanner;

public  class 腾讯士兵差值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        //"001101" 0 表示有攻击性
        char[] chars = s.toCharArray();
        //其实 char 类型也可以
        int [] invadeSum = new int[chars.length+1];
        int [] defentSum = new int[chars.length+1];
        invadeSum[0]=0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='0'){
                invadeSum[i]=invadeSum[i-1]+i+1;
            }else{
                invadeSum[i]=invadeSum[i-1];
            }
        }
        // 防守方从后向前,也是加下标
        defentSum[chars.length]=0;
        for(int i=chars.length-1;i>=0;i--){
            if(chars[i]=='1'){
                defentSum[i]=defentSum[i+1]+i;
            }else{
                defentSum[i]=defentSum[i+1];
            }
        }
        // 求差值最小的

    }
}
