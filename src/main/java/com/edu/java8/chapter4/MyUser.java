package com.edu.java8.chapter4;

public class MyUser implements User,Person {

    @Override
    public void go() {
        System.out.println("go...");
    }

    public static void main(String[] args) {
        MyUser myUser = new MyUser();
        myUser.goToSchool();//默认方法
        System.out.println(User.name()); //接口静态方法
        System.out.println(myUser.idCard());

        //Java8 接口包含实现，某种程度上多继承了呢？
        System.out.println(myUser.score());

    }

    @Override
    public String idCard() {
        return "李四";
    }

}
