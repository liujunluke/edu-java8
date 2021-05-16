package com.edu.java8.chapter4.conflict;

public interface B {

    default void sayHello(){
        System.out.println("Say hello from B");
    }

    default long age(){
        return 100;
    }

}
