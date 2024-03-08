package com.boshrong.leetcode.微软面试;

import java.util.Arrays;
import java.util.Scanner;

public class 美团点菜 {
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //使用动态规划 满足条件 做与不做选一个
        // n个顾客
        n = sc.nextInt();
        // 能做n个菜
        m = sc.nextInt();
        //sc.nextLine();
        int [][] order=new int [n][2];
        for(int i=0;i<n;i++){
            order[i][0] =sc.nextInt();
            order[i][1] =sc.nextInt();
            //sc.nextLine();
        }
        int [] menu=new int[m+1];
        // 标记是否访问
        Arrays.fill(menu,1);
        int res=dfs(0,menu,order);
        System.out.println(res);
    }
    // 思考一下，怎么做 idx 表示在指向个顾客
    public static int dfs(int idx,int [] menu,int[][] order){
        if(idx>=n){
            return 0;
        }
        // 要点的菜在菜单中
        if(menu[order[idx][0]]==1 && menu[order[idx][1]]==1) {
            // 选择做该顾客的菜，或者不做该顾客的菜
            int notChoice = dfs(idx+1, menu, order);
            menu[order[idx][0]] = 0;
            menu[order[idx][1]] = 0;
            // 不要使用idx++,要保证不修改idx 的值
            int choice = dfs(idx+1, menu, order) + 1;
            // 回溯
            menu[order[idx][0]] = 1;
            menu[order[idx][1]] = 1;
            return Math.max(notChoice,choice);
        }
        // 不满足条件，只能不选
        return dfs(idx + 1, menu, order);
    }
}
