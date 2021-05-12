package com.edu.java8.chapter2;

import com.edu.java8.chapter1.Apple;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Test12 {

    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        list.add(new Apple(120,"green"));
        list.add(new Apple(80,"green"));
        list.add(new Apple(150,"red"));
        list.add(new Apple(80,"red"));

        //红苹果
        Predicate<Apple> redPredicate = apple -> apple.getColor().equals("red");
        System.out.println(filterApple(list,redPredicate));

        //重的苹果
        Predicate<Apple> heavyPredicate = apple -> apple.getWeight() > 100;
        System.out.println(filterApple(list,heavyPredicate));

        //红色并且重的苹果
        Predicate<Apple> redHeavyPredicate = redPredicate.and(heavyPredicate);
        System.out.println(filterApple(list,redHeavyPredicate));

        //红色并且重的苹果或者青苹果
        Predicate<Apple> predicate = redHeavyPredicate.or(apple -> apple.getColor().equals("green"));
        System.out.println(filterApple(list,predicate));

        //取反
        Predicate<Apple> negatePredicate = predicate.negate();
        System.out.println(filterApple(list,negatePredicate));

    }

    public static List<Apple> filterApple(List<Apple> list, Predicate<Apple> predicate){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if(predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

}
