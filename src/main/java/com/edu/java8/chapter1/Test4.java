package com.edu.java8.chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Test4 {

    public static void main(String[] args) {
        /*Apple apple = getApple("green");
        System.out.println(apple.getWeight());*/

        Optional<Apple> optional = getApple2("green");
        Apple apple = optional.orElse(new Apple());
        System.out.println(apple.getWeight());

    }


    public static Apple getApple(String color){
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(150,"red"));
        apples.add(new Apple(120,"red"));

        for (Apple apple : apples) {
            if(apple.getColor().equals(color)){
                return apple;
            }
        }
        return null;
    }

    public static Optional<Apple> getApple2(String color){
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(150,"red"));
        apples.add(new Apple(120,"red"));

        Optional<Apple> optional = apples.stream().filter((Apple apple) -> apple.getColor().equals(color)).findFirst();
        return optional;
    }


}
