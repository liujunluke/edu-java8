package com.edu.java8.chapter2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.ToIntFunction;

public class Test8 {

    public static void main(String[] args) {
        //类名::静态方法名
        //类名::实例方法名
        //实例变量名::实例方法名
        //构造方法引用 类名::new

        Student student1 = new Student("zhangsan",90);
        Student student2 = new Student("lisi",70);
        Student student3 = new Student("wangwu",40);
        Student student4 = new Student("zhaoliu",60);
        List<Student> students = Arrays.asList(student1,student2,student3,student4);


        //============================类名::静态方法名===============================
        //需求：按照学生的考试分数进行排序
        /*Comparator<Student> comparator = (s1,s2) -> {
            return Student.compareStaticByScore(s1,s2);
        };
        students.sort(comparator);
        students.forEach(student -> System.out.println(student));*/

        /*Comparator<Student> comparator = Student::compareStaticByScore;
        students.sort(comparator);
        students.forEach(student -> System.out.println(student));*/

        //需求：将字符串转换成整型
        //T -> R Function ToIntFunction
        /*ToIntFunction<String> function = numStr -> Integer.parseInt(numStr);
        System.out.println(function.applyAsInt("123"));*/

        /*ToIntFunction<String> function = Integer::parseInt;
        System.out.println(function.applyAsInt("123"));*/

        //============================类名::实例方法名===============================
        /*Comparator<Student> comparator = (s1,s2) -> {
            return s1.compareByName(s2);
        };
        students.sort(comparator);
        students.forEach(student -> System.out.println(student));*/

        //类名是对应Lambda表达式第一个入参的类型，其他入参作为实例方法的入参
        /*Comparator<Student> comparator = Student::compareByName;
        students.sort(comparator);
        students.forEach(student -> System.out.println(student));*/

        /*BiPredicate<List<Student>,Student> biPredicate = (list,s1) -> {
            return list.contains(s1);
        };*/
        /*BiPredicate<List<Student>,Student> biPredicate = List::contains;
        boolean result = biPredicate.test(students, student1);
        System.out.println(result);*/

        //============================实例变量名::实例方法名===============================
        StudentComparator studentComparator = new StudentComparator();

        /*Comparator<Student> comparator = (s1,s2) -> {
          return studentComparator.compareByScore(s1,s2);
        };*/
        Comparator<Student> comparator = studentComparator::compareByScore;
        students.sort(comparator);
        //students.forEach(student -> System.out.println(student));

        students.forEach(System.out::println);

    }

}
