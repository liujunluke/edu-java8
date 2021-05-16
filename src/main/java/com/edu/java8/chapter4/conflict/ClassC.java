package com.edu.java8.chapter4.conflict;

//public class ClassC implements InterfaceA,InterfaceB {
public class ClassC extends ClassD implements InterfaceA,InterfaceB {

    public static void main(String[] args) {
        ClassC classC = new ClassC();
        classC.sayHello();
    }

}
