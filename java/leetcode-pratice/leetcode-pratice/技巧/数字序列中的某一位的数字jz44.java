package com.boshrong.leetcode.技巧;

import java.util.ArrayList;

public class 数字序列中的某一位的数字jz44 {
    public static void main(String[] args) {
        findNthDigit(500000000);
        //这是数字，不是数字的位数，这是我错的点
    }
    public static int getNUm(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 10;
        }
        return getNUm(n-1)+((int)Math.pow(10,n)-1-((int)Math.pow(10,n-1)-1))*n;
    }

    public static int findNthDigit (int n) {
        // write code here
        if(n<0){
            return 0;
        }
        // 用一个数组保存0-9位的最大位数
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<=9;i++){
            arrayList.add(getNUm(i));
        }
        //存储在该位对应的数字位数
        int lens=0;
        for(int i=0;i<=9;i++){
            if(n>=arrayList.get(i)){
                continue;
            }else{
                lens=i;
                break;
            }
        }

        int num=(n-arrayList.get(lens-1))/lens;
        // 第num 的数
        num=num+(int)Math.pow(10,lens-1);
        if(lens==1){
            num--;
        }
        //确定在num中的第几位
        int kk=n%lens;
        String s = Integer.toString(num);
        return Integer.parseInt(s.substring(kk,kk+1));

    }
}
