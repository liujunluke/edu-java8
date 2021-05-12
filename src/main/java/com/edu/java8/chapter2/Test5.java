package com.edu.java8.chapter2;

import com.edu.java8.chapter1.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * 基本类型函数式接口
 */
public class Test5 {

    public static void main(String[] args) {
        //Int、Long、Double 类型的时候就可以看下系统是否提供了这样的特化的函数式接口

        //testPredicate();

        //IntConsumer
        //LongConsumer
        //DoubleConsumer

        //Function<T,R> T -> R
        //IntFunction int -> R
        //DoubleFunction double -> R
        //ToIntFunction T -> int
        //ToLongFunction T -> long
        //IntToLongFunction  int -> long

        //testIntToLongFunction();

        //BiFunction  (T,U) -> R
        //ToLongBiFunction (T,U) -> long
        //ToIntegerBiFunction (T,U) -> int
        //ToDoubleBiFunction (T,U) -> double
        // (int,int) -> int
        //IntBinaryOperator 元计算函数式接口（下一节课介绍）


        //BiConsumer (T,U) -> void
        //(T,int/long/double) -> void
        //ObjIntConsumer
        //ObjLongConsumer
        //ObjDoubleConsumer

        testObjIntConsumer();


    }

    public static void testPredicate(){
        //输出偶数值
        int[] numbers = new int[] {1,2,3,4,5,6,7,8,9};

        //Predicate<Integer> predicate = number -> number % 2 == 0;
        IntPredicate predicate =  number -> number % 2 == 0;
        //LongPredicate

        for (int number : numbers) {
            if(predicate.test(number)){
                System.out.println(number);
            }
        }

    }

    public static void testIntToLongFunction(){
        int a = Integer.MAX_VALUE;
        System.out.println(a);

        IntToLongFunction function = number -> (long) number * 2;
        long result = function.applyAsLong(a);
        System.out.println(result);

    }

    public static void testObjIntConsumer(){
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(100,"green"));
        apples.add(new Apple(120,"green"));
        apples.add(new Apple(150,"red"));
        apples.add(new Apple(120,"red"));
        System.out.println(apples);

        //给集合里面的每个苹果增重10克
        ObjIntConsumer<Apple> consumer = (apple,weight) -> apple.setWeight(apple.getWeight() + weight);
        for (Apple apple : apples) {
            consumer.accept(apple,10);
        }
        System.out.println(apples);

    }

}
