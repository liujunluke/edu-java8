package com.edu.java8.chapter5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {

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
        List<String> nameList = stream.map(Student::getName).collect(Collectors.toList());
        System.out.println(nameList);
        System.out.println("==================================");
        //流只能遍历一次，即流只能被消费一次
        /*List<String> nameList2 = stream.map(Student::getName).collect(Collectors.toList());
        System.out.println(nameList2);*/
        //Stream<Student> stream1 = students.stream();

        //外部迭代
        for (Student student : students) {
            System.out.println(student.getName());
        }
        System.out.println("==================================");
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.getName());
        }

    }

}
