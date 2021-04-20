package com.edu.java8.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {

        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(100,"green"));
        apples.add(new Apple(120,"green"));
        apples.add(new Apple(120,"red"));
        apples.add(new Apple(150,"red"));

        //需求：过滤出想要的苹果
        /*List<Apple> appleList = filterApples1(apples);
        System.out.println(appleList);*/

        /*List<Apple> appleList = filterApples2(apples);
        System.out.println(appleList);*/

        //行为参数化
        //Lambda表达式，可以让行为参数化得到最大的发挥

        /*List<Apple> appleList = filterApples3(apples, (Apple apple) -> apple.getWeight() >= 120);
        System.out.println(appleList);*/


        List<Apple> appleList = filterApples3(apples, (Apple apple) -> apple.getWeight() >= 120 && apple.getColor().equals("red"));
        System.out.println(appleList);

    }

    public static List<Apple> filterApples1(List<Apple> apples){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if(apple.getWeight() >= 120){
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples2(List<Apple> apples){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if(apple.getColor().equals("red")){
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples3(List<Apple> apples,ApplePredicate applePredicate){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if(applePredicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }


}
