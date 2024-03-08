package com.boshrong.leetcode.设计模式;

public class 适配者模式 {
    public static void main(String[] args) {
        new Adapter(new Speak()).translate();
    }
}
class Speak{
    public String speak(){
        return "Hello World";
    }
}

interface Translate{
    public String translate();
}

class Adapter implements Translate{
    private Speak speak;
    public Adapter(Speak speak){
        this.speak=speak;
    }
    @Override
    public String translate() {
        return speak.speak();
    }
}
