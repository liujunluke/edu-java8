package com.edu.java8.chapter1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test2 {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(100,"green"));
        apples.add(new Apple(120,"green"));
        apples.add(new Apple(120,"red"));
        apples.add(new Apple(150,"red"));

        //对苹果集合按照颜色进行分组
        /*Map<String, List<Apple>> map = groupByColor(apples);
        System.out.println(map);*/

        /*Map<String, List<Apple>> map = groupByColor2(apples);
        System.out.println(map);*/

        //计算集合苹果的总重量
        /*Integer total = apples.stream().collect(Collectors.summingInt(Apple::getWeight));
        System.out.println(total);*/

        Integer total = apples.parallelStream().collect(Collectors.summingInt(Apple::getWeight));
        System.out.println(total);

    }

    public static Map<String,List<Apple>> groupByColor(List<Apple> apples){
        Map<String,List<Apple>> map = new HashMap<>();
        for (Apple apple : apples) {
            String color = apple.getColor();
            List<Apple> appleList = map.get(color);
            if(appleList == null){
                appleList = new ArrayList<>();
                map.put(color,appleList);
            }
            appleList.add(apple);
        }
        return map;
    }

    public static Map<String,List<Apple>> groupByColor2(List<Apple> apples){
        //Map<String, List<Apple>> map = apples.stream().collect(Collectors.groupingBy((Apple apple) -> apple.getColor()));
        Map<String, List<Apple>> map = apples.stream().collect(Collectors.groupingBy(Apple::getColor));

        //方法引用，它是一种Lambda表达式的特殊用法
        return map;
    }

}
