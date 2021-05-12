package com.edu.java8.chapter2;

import com.edu.java8.chapter1.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Test7 {

    public static void main(String[] args) {
        Comparator<Apple> comparator = (Apple a1,Apple a2) -> a1.getWeight() - a2.getWeight();
        List<Apple> apples = new ArrayList<>();
        //compareApple(apples,comparator);

       /* compareApple(apples,(Apple a1,Apple a2) -> a1.getWeight() - a2.getWeight());
        compareApple2(apples,(Apple a1,Apple a2) -> a1.getWeight() - a2.getWeight());*/

        //调用的是哪一个具体方法（存在二义性）
        //compareApple(apples,(Apple a1,Apple a2) -> a1.getWeight() - a2.getWeight());
        //compareApple(apples,(BiFunction<Apple, Apple, Integer>) (Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight());

        //类型推断
        //compareApple(apples,(BiFunction<Apple, Apple, Integer>) (a1, a2) -> a1.getWeight() - a2.getWeight());

        //Lambda表达式访问局部变量
        int weight = 10;
        Consumer<Apple> consumer = apple -> {
            System.out.println(apple.getWeight() + weight);
        };
        consumer.accept(new Apple(100,"red"));
        //weight = 20;

        //Lambda表达式只能访问实例变量和静态变量，对于局部变量必须是最终的（final）或者事实上是最终的变量
        //函数式接口实例的调用consumer.accept()可能发生在另外的一个线程上，实例变量是存储在堆中的（线程共享）、局部变量的存储在栈上（线程独享）
        //那么为什么还可以访问局部变量呢？访问的是局部变量的副本，没有线程共享的问题
    }

    public static void compareApple(List<Apple> list, Comparator<Apple> comparator){
        System.out.println("comparator");
    }

    public static void compareApple2(List<Apple> list, BiFunction<Apple,Apple,Integer> function){
        System.out.println("function");
    }

    public static void compareApple(List<Apple> list, BiFunction<Apple,Apple,Integer> function){
        System.out.println("function");
    }


}
