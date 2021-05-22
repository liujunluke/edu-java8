package com.edu.java8.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test5 {

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

        List<Student> resultList = students
                .stream()
                .filter(student -> student.getScore() >= 90)
                //.limit(10)
                .skip(4)//跳过指定个数元素
                .collect(Collectors.toList());
        System.out.println(resultList);


        //limit()：返回最多指定个数的元素（前n个）
        //skip()：跳过指定个数元素，跳过的个数超过过滤结果，将返回空流。

    }


}
