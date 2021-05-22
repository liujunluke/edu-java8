package com.edu.java8.chapter5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test4 {

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
                        new Student("李俊", 17, 50, 3),
                        new Student("关胜", 17, 50, 3));

        //筛选功能
        /*List<Student> resultList = students
                .stream()
                .filter(student -> student.getAge() == 17)
                .collect(Collectors.toList());
        System.out.println(resultList);*/

        //去重
        /*List<Student> resultList = students
                .stream()
                .filter(student -> student.getAge() == 17)
                .distinct()
                //.limit(2)
                .collect(Collectors.toList());
        System.out.println(resultList);*/

        /*HashSet<Student> students1 = new HashSet<>();
        students1.add(new Student("关胜", 17, 50, 3));
        students1.add(new Student("李俊", 17, 50, 3));
        students1.add(new Student("关胜", 17, 50, 3));
        students1.add(new Student("石秀", 17, 100, 3));*/




        /*List<Student> resultList = students1
                //.stream()
                .parallelStream()
                .filter(student -> student.getAge() == 17)
                .distinct()
                //.limit(2)
                .collect(Collectors.toList());
        System.out.println(resultList);*/

        //多线程执行去重，有序的流式昂贵的。
        //多线程执行去重，无序的流更高效。
        //多线程执行去重，有序的流式昂贵的。低效率、低内存利用率，可以通过sequential()方法提供性能。

        Stream<Student> parallelStream = students.parallelStream();
        Stream<Student> sequential = parallelStream.sequential();//将多线程流转换成单线程流
        //sequential.filter().distinct().collect()

    }

}
