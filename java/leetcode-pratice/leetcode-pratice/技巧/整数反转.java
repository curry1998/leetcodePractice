package com.boshrong.leetcode.技巧;

public class 整数反转 {
    public static void main(String[] args) {
        int x=1534236469;
        System.out.println(reverse(x));

    }
    public static int reverse(int x) {

        int flag=1;
        //进行处理，方便操作
        //只有两种情况和boolean 雷系
        if(x<0){
            x=-x;
            flag=-1;
        }
        int res=0;
        while(x!=0){
            int j=x%10;
            x=x/10;
            int tmp=res;
            res=tmp*10+j;
            //溢出的判断
            if((res/10)!=tmp){
                return 0;
            }

        }
        if(flag==-1)
            res=-res;
        return res;
    }
}
