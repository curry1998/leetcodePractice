package com.boshrong.leetcode.设计模式;

import org.springframework.boot.autoconfigure.SpringBootApplication;


public class 单例模式 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();
        System.out.println(singleton==singleton2);
    }
}
class Singleton{
    // volatile 保证线程可见性，指令重排序
    private volatile static Singleton singleton;
    public Singleton(){

    }
    // 双重检查锁 先判断对象是否被初始化，再确定要不要加锁
    // 如果直接加到方法上,因为加锁其实只需要在第一次初始化的时候用到，之后的调用都没必要再进行加锁。
     public static Singleton getSingleton(){
        //
        if(singleton==null){
            // 如果还为空，进行同步
            synchronized (Singleton.class){
                //再次检查变量是否已经被初始化
                if(singleton==null){
                   singleton = new Singleton();
                }
            }
        }
        return singleton;
     }
}
