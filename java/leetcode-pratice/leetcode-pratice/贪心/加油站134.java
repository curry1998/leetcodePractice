package com.boshrong.leetcode.贪心;

public class 加油站134 {
    // 暴力会超时
   public int canCompleteCircuit(int[] gas, int[] cost) {
//        //遍历所有的起点，看能否返回，能返回说明该解存在。
//        int n = gas.length;
//        int m = cost.length;
//        for(int i=0;i<n;i++){
//            //g 从i 走到 i+1 剩余的汽油
//            int g = gas[i]-cost[i];
//            //环形操作
//            int j = (i+1)%gas.length;
//            while(g>=0 && j!=i){
//                g += gas[j]-cost[j];
//                j = (j+1)%gas.length;
//            }
//            if(g>=0 &&j==i){
//                return i;
//            }
//        }
//        return -1;
//    }

    // 贪心算法,要覆盖所有的旅程，找到消耗累加的最低点，避过最低点，则就是index

           //时间复杂度o(n)解法
           int n = gas.length;
           int total =0,minvalue=Integer.MAX_VALUE,minindex=0;
           for(int i=0;i<n;i++){
               total +=gas[i] -cost[i];
               if(total<minvalue){
                   minvalue = total;
                   minindex = i;
               }
           }
           // total<0不够环游一圈
           return total<0 ? -1:(minindex+1)%n;
       }
}
