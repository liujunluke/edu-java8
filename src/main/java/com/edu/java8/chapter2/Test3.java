package com.edu.java8.chapter2;

import com.edu.java8.chapter1.Apple;

import java.util.function.BiConsumer;

public class Test3 {

    public static void main(String[] args) {
        //只要Lambda表达式的签名符合函数式接口的抽象方法，那么就可以赋值该函数式接口

        BiConsumer<Apple,Apple> biConsumer = (Apple a1,Apple a2) -> {
            System.out.println(a1.getWeight() + a2.getWeight());
        };
        biConsumer.accept(new Apple(100,"red"),new Apple(120,"green"));



    }

}
