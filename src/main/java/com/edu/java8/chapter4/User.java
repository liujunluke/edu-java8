package com.edu.java8.chapter4;

public interface User {

    void go();

    default void goToSchool(){
        go();
    }

    static String name(){
        return "张三";
    }

    default String idCard(){
        return "你好：" + name();
    }

}
