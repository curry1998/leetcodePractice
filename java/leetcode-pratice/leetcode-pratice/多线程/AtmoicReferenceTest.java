package com.boshrong.leetcode.多线程;

import java.util.concurrent.atomic.AtomicReference;

public class AtmoicReferenceTest {
    public static AtomicReference<User> atr = new AtomicReference<>();
    public static void main(String[] args) {
        User user = new User(1,"boshrong");
        atr.set(user);
        User user1 = new User(2,"tom");
        atr.compareAndSet(user,user1);
        System.out.println(atr.get().getId());
        System.out.println(atr.get().getName());
    }
}

class User{
    int id;
    String name;
    public User(int id,String name){
        this.id = id;
        this.name = name;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}
