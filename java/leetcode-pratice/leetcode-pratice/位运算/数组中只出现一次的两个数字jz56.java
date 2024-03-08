package com.boshrong.leetcode.位运算;

public class 数组中只出现一次的两个数字jz56 {
    public static void main(String[] args) {
        FindNumsAppearOnce(new int[]{1,2,3,3,2,9});
    }
    public static int[] FindNumsAppearOnce (int[] array) {
        int lens=array.length;
        if(lens==0){
            return new int[]{};
        }
        // 0与任何数异或都为任何数
        int tmp=0;
        for(int num : array){
            tmp^=num;
        }
        //pos左移找到a 和b 不同的位
        int pos=1;
        while((tmp&pos)==0){
            pos=pos<<1;
        }
        // 根据第i 位是否相等进行分组
        int a=0,b=0;
        for(int i=0;i<lens;i++){
            if((array[i]&pos)==0){
                a^=array[i];
            }else{
                b^=array[i];
            }
        }
        //降序排列
        if(a>b){
            int v=a;
            a=b;
            b=v;
        }

        return new int[]{a,b};
    }
}
