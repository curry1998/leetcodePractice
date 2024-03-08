package com.boshrong.leetcode.微软面试;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 第K小子串_腾讯 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in=sc.nextLine();
        int k=sc.nextInt();
        sc.close();
        // 注意 1<=k<=5
        int lens=in.length();
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2)  {
                return o1.compareTo(o2);
            }
        });
        HashSet<String> set = new HashSet<>();
        for(int len=1;len<=lens;len++){
            for(int i=0;i+len<=lens;i++){
                int j=i+len;
                String str=in.substring(i,j);
                if(!set.contains(str)){
                    set.add(str);
                    queue.add(str);
                }else{
                    continue;
                }
            }
        }
        for(int i=1;i<k;i++){
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
