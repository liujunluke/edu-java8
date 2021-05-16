package com.edu.java8.chapter4.conflict;

public interface IA extends A {

    @Override
    default void sayHello() {
        //System.out.println("Say hello from IA");
        A.super.sayHello();
    }

}
