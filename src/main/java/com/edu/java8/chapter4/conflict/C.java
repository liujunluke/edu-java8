package com.edu.java8.chapter4.conflict;

public class C implements A,B{

    //显示覆盖默认方法实现
    @Override
    public void sayHello() {
        //显示调用默认方法
        A.super.sayHello();
    }

    public static void main(String[] args) {
        new C().sayHello();
    }

}
