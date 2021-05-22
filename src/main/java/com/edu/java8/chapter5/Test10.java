package com.edu.java8.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test10 {

    public static void main(String[] args) {
        List<Student> students =
                Arrays.asList(new Student("宋江", 15, 80, 2),
                        new Student("林冲", 15, 80, 2),
                        /*new Student("柴进", 15, 70, 2),
                        new Student("鲁智深", 18, 70, 2),
                        new Student("武松", 18, 60, 1),
                        new Student("花荣", 18, 60, 1),
                        new Student("秦明", 16, 90, 1),
                        new Student("李逵", 16, 90, 1),
                        new Student("史进", 16, 100, 3),
                        new Student("石秀", 17, 100, 3),
                        new Student("关胜", 17, 50, 3),*/
                        new Student("李俊", 17, 50, 3));

        //元素求和
        /*Integer ageTotal = students.stream()
                .map(Student::getAge)
                .reduce(0, (age1, age2) -> age1 + age2);//累加过程
        System.out.println(ageTotal);*/

        /*Optional<Integer> optional = students.stream()
                .map(Student::getAge)
                .reduce(Integer::sum);
        optional.ifPresent(System.out::println);*/

        //求最大年龄
        /*Optional<Integer> optional = students.stream()
                .map(Student::getAge)
                .reduce(Integer::max);
        optional.ifPresent(System.out::println);*/

        //求最小年龄
        /*Optional<Integer> optional = students.stream()
                .map(Student::getAge)
                .reduce(Integer::min);
        optional.ifPresent(System.out::println);*/


        //需求：计算大于15岁的学生的个数
        Optional<Integer> optional = students.stream()
                .filter(student -> student.getAge() > 15)
                .map(student -> 1)
                .reduce(Integer::sum);
        optional.ifPresent(System.out::println);

    }

}
