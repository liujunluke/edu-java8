package com.edu.java8.chapter4.conflict;

public class CD implements IA,IB{

    @Override
    public void sayHello() {
        //System.out.println("say hello from CD");
        IA.super.sayHello();
    }

    public static void main(String[] args) {
        new CD().sayHello();
    }

}
