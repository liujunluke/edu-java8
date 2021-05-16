package com.edu.java8.chapter4.conflict;

public interface A {

    default void sayHello(){
        System.out.println("Say hello from A");
    }

    /*default int age(){
        return 100;
    }*/

}
