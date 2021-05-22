package com.edu.java8.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test6 {

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

        //映射
        /*List<Integer> resultList = students.stream()
                .map(Student::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(resultList);*/

        //映射扁平化
        List<String> list = Arrays.asList("我是中国人","我爱中国");
        //需求：返回这两句话去重后的字的集合：[我,是,中,国,人,爱]

        /*List<String[]> result = list.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result);*/

        //将数组转换成流
        String[] arrays = {"你好吗","你们好呀"};
        Stream<String> stream = Arrays.stream(arrays);

        List<String> result = list.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                //.distinct()
                .collect(Collectors.toList());
        System.out.println(result);

    }

}
