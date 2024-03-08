package com.boshrong.leetcode.二分;

import java.util.Arrays;

public class 供暖器475 {
    public static void main(String[] args) {
        findRadius(new int[]{1,2,3},new int[]{2});
    }
    public static int findRadius(int[] houses, int[] heaters) {
        // 思路: 二分找半径R,其坐标可能没有顺序，需排序
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l=0,r=Integer.MAX_VALUE;
        while(l<r){
            int mid=(l+r)/2;
            if(checkOver(mid,houses,heaters)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return r;


    }
    //给定半径r,判断heart 能否覆盖所有房子
    public static boolean checkOver(int r,int [] houses,int [] heaters){
        //从house 里面取值，减去hearts中的值，如果heaert中还有值说明能覆盖
        // i指向house j指向hearters
        for(int i=0,j=0;i<houses.length;i++){
            while(j<heaters.length && Math.abs(heaters[j]-houses[i])>r){
                j++;
            }
            if(j==heaters.length){
                return false;
            }

        }
        return true;
    }
}
