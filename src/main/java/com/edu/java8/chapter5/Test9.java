package com.edu.java8.chapter5;

import java.util.Arrays;
import java.util.List;

public class Test9 {

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

        //allMatch
        boolean result = students.stream()
                //.allMatch(student -> student.getAge() >= 18);
                //.allMatch(student -> student.getAge() >= 16);
                .allMatch(student -> student.getAge() >= 15);
        System.out.println(result);


        //anyMatch
        boolean result2 = students.stream()
                .anyMatch(student -> student.getScore() == 120);
        System.out.println(result2);

        //noneMatch
        boolean result3 = students.stream()
                .noneMatch(student -> student.getName().length() >= 3);
        System.out.println(result3);


    }

}
