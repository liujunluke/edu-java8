package com.edu.java8.chapter4.conflict;

public class ClassD implements InterfaceA {

    @Override
    public void sayHello() {
        //System.out.println("Say hello from ClassD");
        //显式调用
        InterfaceA.super.sayHello();
    }

}
