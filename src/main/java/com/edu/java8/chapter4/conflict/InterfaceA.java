package com.edu.java8.chapter4.conflict;

public interface InterfaceA {

    default void sayHello(){
        System.out.println("Say hello from InterfaceA");
    }

}
