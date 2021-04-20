package com.edu.java8.chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Test3 {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(100,"green"));
        apples.add(new Apple(120,"green"));
        apples.add(new Apple(150,"red"));
        apples.add(new Apple(120,"red"));

        /*List<Apple> appleList = filterApples3(apples, (Apple apple) -> apple.getColor().equals("red"));
        System.out.println(appleList);*/

        //@FunctionalInterface:系统所有使用该注解的接口都是函数式接口
        //如果我们自己定义的接口加上该注解，如果不满足函数式接口的定义，那么就会报错
        //即使没有该注解标识的接口，只要满足函数式接口的定义，那么系统仍然将该接口视为函数式接口

        apples.sort((Apple apple1,Apple apple2) -> apple1.getWeight() - apple2.getWeight());
        System.out.println(apples);

    }

    public static List<Apple> filterApples3(List<Apple> apples, Predicate<Apple> applePredicate){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if(applePredicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

}
