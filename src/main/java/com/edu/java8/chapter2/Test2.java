package com.edu.java8.chapter2;

import com.edu.java8.chapter1.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(100,"green"));
        apples.add(new Apple(120,"green"));
        apples.add(new Apple(150,"red"));
        apples.add(new Apple(120,"red"));

        /*Comparator<Apple> comparator = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        };*/
        //行为参数化
        /*apples.sort(comparator);
        System.out.println(apples);*/

        //函数式接口是Lambda表达式的使用条件

        /*Comparator<Apple> comparator = (Apple o1, Apple o2) -> {
            return o1.getWeight() - o2.getWeight();
        };*/

        //类型推断机制
        /*Comparator<Apple> comparator = (o1,o2) -> {
            return o1.getWeight() - o2.getWeight();
        };*/

        Comparator<Apple> comparator = (o1,o2) -> o1.getWeight() - o2.getWeight();

        apples.sort(comparator);
        System.out.println(apples);


        //1、参数列表：参数类型可以省略
        //2、箭头符号
        //3、函数主体


    }

}
