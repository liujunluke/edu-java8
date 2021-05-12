package com.edu.java8.chapter2;

import com.edu.java8.chapter1.Apple;
import com.edu.java8.chapter1.ApplePredicate;

public class ApplePredicateByWeight implements ApplePredicate {

    private Integer weight;

    public ApplePredicateByWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > weight;
    }

}
