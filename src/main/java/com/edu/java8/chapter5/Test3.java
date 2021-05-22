package com.edu.java8.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test3 {

    public static void main(String[] args) {
        List<Student> students =
                Arrays.asList(new Student("宋江", 15, 80, 2),
                        new Student("林冲", 15, 80, 2),
                        new Student("柴进", 15, 70, 2),
                        new Student("鲁智深", 18, 70, 2),
                        new Student("武松", 18, 60, 1),
                        new Student("花荣", 18, 60, 1),
                        new Student("秦明", 16, 90, 1),
                        new Student("李逵", 16, 90, 1),
                        new Student("史进", 16, 100, 3),
                        new Student("石秀", 17, 100, 3),
                        new Student("关胜", 17, 50, 3),
                        new Student("李俊", 17, 50, 3));


        Stream<Student> stream = students.stream();
        /*List<String> resultList = stream
                .filter(student -> student.getAge() >= 16)//中间操作
                .map(Student::getName)//中间操作
                .limit(5)//中间操作
                .collect(Collectors.toList());//终止操作
        System.out.println(resultList);*/

        /*stream
                .filter(student -> {
                    System.out.println("filter: " + student);
                    return student.getAge() >= 16;
                })//中间操作
                .map(student -> {
                    System.out.println("map: " + student);
                    return student.getName();
                })//中间操作
                .limit(5)//中间操作
                .collect(Collectors.toList());//终止操作*/

        long count = stream
                .filter(student -> {
                    System.out.println("filter: " + student);
                    return student.getAge() >= 16;
                })//中间操作
                .map(student -> {
                    System.out.println("map: " + student);
                    return student.getName();
                })//中间操作
                .limit(5)//中间操作
                .count();
        System.out.println(count);

    }

}
