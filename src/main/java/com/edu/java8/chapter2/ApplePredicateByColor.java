package com.edu.java8.chapter2;

import com.edu.java8.chapter1.Apple;
import com.edu.java8.chapter1.ApplePredicate;

public class ApplePredicateByColor implements ApplePredicate {

    private String color;

    public ApplePredicateByColor(String color) {
        this.color = color;
    }

    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals(color);
    }

}
