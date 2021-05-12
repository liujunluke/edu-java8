package com.edu.java8.chapter2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

/**
 * 系统函数式接口
 */
public class Test4 {

    public static void main(String[] args) {
        //Predicate<T> T -> boolean
        //Consumer<T> T -> void
        //Function<T,R> T -> R

        //BiPredicate<T,U> (T,U) -> boolean
        //BiConsumer<T,U> (T,U) -> void
        //BiFunction<T,U,R> (T,U) -> R


//        testPredicate();
//        testConsumer();
        //testFunction();

        testBiFunction();

    }

    public static void testPredicate(){
        List<String> nameList = Arrays.asList("zhangsan","lisi","wangwu");

        String result = filter(nameList, name -> name.equals("zhangsan"));
        System.out.println(result);

    }

    public static String filter(List<String> list, Predicate<String> predicate){
        for (String s : list) {
            if(predicate.test(s)){
                return s;
            }
        }
        return null;
    }

    public static void testConsumer(){
        List<String> nameList = Arrays.asList("zhangsan","lisi","wangwu");
        printName(nameList,name -> System.out.println("Hello," + name));
    }

    public static void printName(List<String> nameList, Consumer<String> consumer){
        for (String item : nameList) {
            consumer.accept(item);
        }
    }


    public static void testFunction(){
        List<String> nameList = Arrays.asList("zhangsan","lisi","wangwu");
        Map<String, Integer> map = convertToLength(nameList, name -> name.length());
        System.out.println(map);
    }

    public static Map<String,Integer> convertToLength(List<String> nameList, Function<String,Integer> function){
        Map<String,Integer> map = new HashMap<>();
        for (String item : nameList) {
            Integer result = function.apply(item);
            map.put(item,result);
        }
        return map;
    }

    public static void testBiFunction(){
        BiFunction<Integer,Integer,Integer> addFunction = (a1,a2) -> a1 + a2;

        Integer a = 10;
        Integer b = 40;
        Integer result = addFunction.apply(a, b);
        System.out.println(result);

    }

}
