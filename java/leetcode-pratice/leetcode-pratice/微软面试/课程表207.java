package com.boshrong.leetcode.微软面试;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class 课程表207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 课程号是从 0~numCourses
        // 后面只需要写一个，前面写好就行
        ArrayList<ArrayList<Integer>> edege = new ArrayList<>();
        int [] indp=new int[numCourses];
        int lens=prerequisites.length;
        for (int i=0;i<numCourses;i++){
            edege.add(new ArrayList<>());
        }
        for(int [] oneEdge : prerequisites){
            // edge 存放课程以及它们的出度结点
            edege.get(oneEdge[1]).add(oneEdge[0]);
            // 记录入度的长度
            indp[oneEdge[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indp[i]==0){
                queue.add(i);
            }
        }
        int visit=0;
        while(!queue.isEmpty()){
            visit++;
            Integer poll = queue.poll();
            ArrayList<Integer> list = edege.get(poll);
            for(int i=0;i<list.size();i++){
                indp[list.get(i)]--;
                if(indp[list.get(i)]==0){
                    queue.add(list.get(i));
                }
            }
        }
        return visit==numCourses;
    }


}
