package com.edu.java8.chapter4.conflict;

public interface InterfaceB extends InterfaceA {

    default void sayHello(){
        System.out.println("Say hello from InterfaceB");
    }

}
