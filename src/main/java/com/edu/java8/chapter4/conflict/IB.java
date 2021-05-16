package com.edu.java8.chapter4.conflict;

public interface IB extends A {

    @Override
    default void sayHello() {
        System.out.println("Say hello from IB");
    }

}
