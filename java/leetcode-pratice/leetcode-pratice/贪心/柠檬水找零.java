package com.boshrong.leetcode.贪心;

public class 柠檬水找零 {
    public boolean lemonadeChange(int[] bills) {
        // 遍历一遍即可，遇到20的优先找10美元的
        int n = bills.length;
        int twenty=0,ten=0,five=0;
        for(int i=0;i<n;i++){
            if(bills[i]==5){
                five++;
            }else if(bills[i]==10){
                five--;
                if(five<0){
                    System.out.println(i);
                    return false;
                }
                ten++;
            }else if(bills[i] ==20){
                if(ten>0){
                    ten--;
                    five--;
                }else{
                    five-=3;
                }
                if(five<0){
                    System.out.println(i);
                    return false;
                }
                twenty++;
            }
        }
        return true;
    }
}
