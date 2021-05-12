package com.edu.java8.chapter2;

import java.util.function.Consumer;
import java.util.function.Function;

public class Test11 {

    public static void main(String[] args) {
        Student student = new Student("zhangsan",80);
        Consumer<Student> consumer = s -> System.out.println("你好，" + s.getName());
        //consumer.accept(student);

        Consumer<Student> consumer2 = s -> System.out.println("考试成绩，" + s.getScore());
        Consumer<Student> newConsumer = consumer.andThen(consumer2);
        newConsumer.accept(student);

        System.out.println("=======================================");
        Function<Integer,Integer> f1 = num -> num + num;
        Function<Integer,Integer> f2 = num -> num * num;

        int num = 5;
        Function<Integer, Integer> function = f1.andThen(f2);
        System.out.println(function.apply(num)); //100

        Function<Integer, Integer> function1 = f1.compose(f2);
        System.out.println(function1.apply(num)); //50

        //andThen() 数学上 f2(f1(x))
        //compose() 数学上 f1(f2(x))

    }

}
