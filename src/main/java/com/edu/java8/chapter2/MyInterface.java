package com.edu.java8.chapter2;

//通知编译器，去检查该接口是否符合函数式接口的定义
@FunctionalInterface
public interface MyInterface {

    int add(int a,int b);

    //签名和Object类一致的方法，不会被视作是函数式接口当中的一个抽象方法
    boolean equals(Object obj);

    //int delete(int a,int b);

}
