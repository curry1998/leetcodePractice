package com.boshrong.leetcode.设计题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;

public class 实现一个线程池 {
}

class Job{

    public  void run(){

    }
}
class ThreadPool{
    // 线程初始限定大小
    private int threadNum;
    //已经工作的线程数目
    private int workThreadNum;
    private ArrayList<Thread> threads;
    private ArrayBlockingQueue<Job> jobs;
    private volatile boolean stop=false;
    public ThreadPool(int threadNum){
        this.threadNum=threadNum;
        threads=new ArrayList<>(threadNum);
        jobs=new ArrayBlockingQueue<>(threadNum*2);
        workThreadNum=0;
    }
    public void addJob(Job job){
        if(jobs.size()>workThreadNum*2){
            return;
        }
        jobs.add(job);
    }
    public void Run(){
        

    }
}
