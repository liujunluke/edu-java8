package com.edu.java8.chapter2;

import com.edu.java8.chapter1.Apple;
import com.edu.java8.chapter1.ApplePredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 行为参数化
 */
public class Test1 {

    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        list.add(new Apple(100,"green"));
        list.add(new Apple(120,"green"));
        list.add(new Apple(120,"red"));
        list.add(new Apple(150,"red"));

        /*List<Apple> apples = filter1(list, 100, "red");
        System.out.println(apples);*/

        //使用策略模式去实现行为参数化
        /*List<Apple> apples = filter2(list, new ApplePredicateByColor("red"));
        System.out.println(apples);*/

        //使用匿名内部类去实现行为参数化
        /*List<Apple> apples = filter2(list, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 100 && apple.getColor().equals("red");
            }
        });
        System.out.println(apples);*/

        //Java8 借助于Lambda表达式去实现行为参数化
        /*List<Apple> apples = filter2(list,
                (Apple apple) -> apple.getWeight() > 100 && apple.getColor().equals("red"));
        System.out.println(apples);*/

        /*List<Apple> apples = filterList(list, (Apple apple) -> apple.getWeight() > 100 && apple.getColor().equals("red"));
        System.out.println(apples);*/

        List<String> nameList = Arrays.asList("zhangsan","lisi","wangwu");
        List<String> filterList = filterList(nameList, (String name) -> name.length() > 4);
        System.out.println(filterList);

    }

    public static List<Apple> filterByColor(List<Apple> inventory,String color){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(apple.getColor().equals(color)){
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterByWeight(List<Apple> inventory,Integer weight){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(apple.getWeight() > weight){
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filter1(List<Apple> inventory,Integer weight,String color){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(apple.getWeight() > weight && apple.getColor().equals(color)){
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filter2(List<Apple> inventory, ApplePredicate predicate){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static <T> List<T> filterList(List<T> inventory, Predicate<T> predicate){
        List<T> result = new ArrayList<>();
        for(T t : inventory){
            if(predicate.test(t)){
                result.add(t);
            }
        }
        return result;
    }

}
