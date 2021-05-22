package com.edu.java8.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test7 {

    public static void main(String[] args) {
        List<Integer> arrays1 = Arrays.asList(1,2,3);
        List<Integer> arrays2 = Arrays.asList(4,5);

        //希望返回数对 List<int[]>，[(1,4),(1,5),(2,4),(2,5),(3,4),(3,5)]

        List<int[]> result = arrays1.stream()
                .flatMap(num1 -> arrays2.stream().map(num2 -> new int[]{num1, num2}))
                .collect(Collectors.toList());
        result.forEach(numbers -> System.out.println(numbers[0] + "," + numbers[1]));

    }

}
