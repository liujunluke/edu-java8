package com.edu.java8.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Test9 {

    public static void main(String[] args) {
        //构造方法引用 类名::new

        /*Supplier<Student> supplier = () -> new Student();
        System.out.println(supplier.get());*/

        /*Supplier<Student> supplier = Student::new;
        System.out.println(supplier.get());*/


        //一个入参的构造方法引用
        // T -> R name -> Student
        /*Function<String,Student> function = name -> new Student(name);
        System.out.println(function.apply("lisi"));*/

        /*Function<String,Student> function = Student::new;
        System.out.println(function.apply("lisi"));*/

        //需求：通过名字集合初始化，返回学生集合
        List<String> nameList = Arrays.asList("张三","李四","王五");
        List<Student> students = initStudent(nameList, Student::new);
        System.out.println(students);

        //针对两个入参的方法引用
        // (T,U) -> Student
//        BiFunction<String,Integer,Student> biFunction = (name,score) -> new Student(name,score);
        BiFunction<String,Integer,Student> biFunction = Student::new;
        Student student = biFunction.apply("lisi", 100);
        System.out.println(student);

    }

    public static List<Student> initStudent(List<String> nameList,Function<String,Student> function){
        List<Student> result = new ArrayList<>();
        for (String name : nameList) {
            Student student = function.apply(name);
            result.add(student);
        }
        return result;
    }

}
