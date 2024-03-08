package com.boshrong.leetcode.设计模式;

import java.text.DateFormat;

// 优点实现对象的创建和使用分离，创建全部交给工厂实现。
// 缺点工厂类不够灵活，新增一个产品就要修改工厂类。
public class 简单工厂模式 {
    public static Factory getBean(String type){
        if(type.equals("A")){
            return new ProductA();
        }
        if(type.equals("B")){
            return new ProductB();
        }
        return null;
    }
    public static void main(String[] args) {
        Factory a = 简单工厂模式.getBean("A");
        a.Print();

    }
}
abstract class Factory{
    //定义抽象方法
    abstract public void Print();
}

// 生成两个产品
class ProductA extends Factory{
    public void Print(){
        System.out.println("printA");
    }
}
class ProductB extends  Factory{
    public void Print(){
        System.out.println("printB");
    }
}
