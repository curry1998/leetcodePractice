package com.boshrong.leetcode.设计模式;

public class 代理模式 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
      new realSubjectProxy().doWork();
    }
}

interface subject{
   void doWork();
}

class realSubject implements subject{

    @Override
    public void doWork() {
        System.out.println("realSubject do some jos");
    }

}

//建立代理类和目标类的关联
class realSubjectProxy implements subject{
    private realSubject subject;
    //通过类加载的方式进行加载
    public realSubjectProxy() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.subject=(realSubject) this.getClass().getClassLoader().loadClass("com.boshrong.leetcode.设计模式.代理模式.realSubject").newInstance();
    }
    @Override
    public void doWork() {
        subject.doWork();
    }

    public void preRequest(){
        System.out.println("preRequest");
    }
}

