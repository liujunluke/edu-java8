package com.edu.java8.chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {

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


        //需求：查询年龄在16岁及以上的前5名学生的名字，并返回一个名字集合
        System.out.println(findNamesBeforeJava8(students));

        Stream<Student> stream = students.stream();
        List<String> resultList = stream.filter(student -> student.getAge() >= 16)
                .map(Student::getName)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(resultList);

        //流式编程：声明式（表达要做什么，而不是怎么做），流水线作业

    }

    public static List<String> findNamesBeforeJava8(List<Student> students){
        List<String> resultList = new ArrayList<>();
        for (Student student : students) {
            if(resultList.size() < 5 && student.getAge() >= 16){
                resultList.add(student.getName());
            }
        }
        return resultList;
    }


}
