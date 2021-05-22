package com.edu.java8.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Test11 {

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

        //流转化为数值流
        IntStream intStream = students.stream()
                .mapToInt(Student::getAge);

        //求和
        /*int sum = intStream.sum();
        System.out.println("求和：" + sum);*/
        //最大值
        /*OptionalInt max = intStream.max();
        System.out.println("最大值：" + max.getAsInt());*/
        //最小值
        /*OptionalInt min = intStream.min();
        min.ifPresent(min1 -> {
            System.out.println("最小值：" + min1);
        });*/

        //平均值
        /*OptionalDouble average = intStream.average();
        System.out.println("平均值：" + average.getAsDouble());*/

        Stream<Integer> boxedStream = intStream.boxed();
        //boxedStream
        //boxedStream.max


        //通过数值范围来构建数值流
        //LongStream range = LongStream.range(1, 100);
        LongStream range = LongStream.rangeClosed(1, 100);
        long count = range.filter(num -> num % 2 == 0)
                .count();
        System.out.println(count);

    }


}
