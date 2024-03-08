package com.boshrong.leetcode.dp;

public class 连续子数组的最大和jz85 {
    public static void main(String[] args) {
        int[] ints = {0,0,0,0,-1,1,-2};
        FindGreatestSumOfSubArray(ints);
    }

    public static int[] FindGreatestSumOfSubArray (int[] array) {
        // write code here
        int lens=array.length;
        if(lens<0){
            return new int[]{};
        }
        //定义结构存储最终的结果
        int[] dp = new int[lens];
        //生成一个二维数组
        //存储起始和结束位置
        int [][] startEnd=new int[lens][2];
        dp[0]=array[0];
        startEnd[0][0]=0;
        startEnd[0][1]=0;
        for(int i=1;i<lens;i++){
            int value=dp[i-1]+array[i];
            if(value>=array[i]){
                startEnd[i][0]=startEnd[i-1][0];
                startEnd[i][1]=i;
                dp[i]=value;
            }else{
                startEnd[i][0]=i;
                startEnd[i][1]=i;
                dp[i]=array[i];
            }
        }

        int result=Integer.MIN_VALUE;
        int start=0,end=0;
        int spanFirst=0;
        for(int i=0;i<lens;i++){
            if(dp[i]>=result){
                if(dp[i]==result){
                    if(spanFirst<=(startEnd[i][1]-startEnd[i][0])){
                        start=startEnd[i][0];
                        end=startEnd[i][1];
                        spanFirst=end-start;
                    }
                }else{
                    start=startEnd[i][0];
                    end=startEnd[i][1];
                    spanFirst=end-start;
                }
                result=dp[i];
            }
        }
        //进行复制
        int span=end-start;
        int[] ints = new int[span+1];
        for(int i=0;i<span+1;i++){
            ints[i]=array[start];
            start++;
        }
        return ints;
    }

}
