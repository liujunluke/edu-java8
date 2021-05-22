package com.edu.java8.chapter5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test12 {

    public static void main(String[] args) {
        //通过数值序列来构建流
        Stream<String> stream = Stream.of("张三", "李四", "王五");
        stream.forEach(System.out::println);

        //通过数组来构建流
        int[] arrays = new int[]{1,2,3,4,5};
        IntStream intStream = Arrays.stream(arrays);
        System.out.println(intStream.sum());

        //通过文件来构建流
        try {
            Stream<String> linesStream =
                    Files.lines(Paths.get("D:\\workspaces2020\\edu-java8\\src\\main\\resources\\names.txt"));
            //linesStream.forEach(System.out::println);
            Stream<String> stringStream = linesStream.flatMap(line -> Arrays.stream(line.split(" ")));
            stringStream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //构建无限流
        Stream<Integer> iterateStream = Stream.iterate(1, num -> num + num).limit(10);
        iterateStream.forEach(System.out::println);
        System.out.println("================================");

        Random random = new Random();
        Stream<Integer> generateStream = Stream.generate(() -> random.nextInt()).limit(10);
        generateStream.forEach(System.out::println);


    }

}
