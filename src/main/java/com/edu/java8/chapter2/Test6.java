package com.edu.java8.chapter2;

import com.edu.java8.chapter1.Apple;

import java.util.Comparator;
import java.util.function.*;

public class Test6 {

    public static void main(String[] args) {
        //一元运算函数式接口
        //UnaryOperator T -> T
        //testUnaryOperator();

        //二元运算函数式接口
        //BinaryOperator (T,T) -> T
        //testBinaryOperator();

        //Supplier () -> T
        testSupplier();

    }

    public static void testUnaryOperator(){
        UnaryOperator<Integer> operator = num -> num * 2;
        Integer result = operator.apply(2);
        System.out.println(result);

        Function<Integer,Integer> function = num -> num * 2;
        Integer result2 = function.apply(2);
        System.out.println(result2);

        //Int、Long、Double
        IntUnaryOperator intUnaryOperator = num -> num * 2;
        int result3 = intUnaryOperator.applyAsInt(2);
        System.out.println(result3);
        //LongUnaryOperator
        //DoubleUnaryOperator
    }

    public static void testBinaryOperator(){
        BinaryOperator<Integer> operator = (num1,num2) -> num1 + num2;
        Integer result = operator.apply(10, 20);
        System.out.println(result);

        BinaryOperator<Integer> operator1 = (a,b) -> 1;
        System.out.println(operator1.apply(10,20));

        Comparator<Apple> comparator = (a1,a2) -> a1.getWeight() - a2.getWeight();
        BinaryOperator<Apple> appleOperator = BinaryOperator.minBy(comparator);
        Apple minApple = appleOperator.apply(new Apple(100, "red"), new Apple(120, "red"));
        System.out.println(minApple);
    }

    public static void testSupplier(){
        //延迟计算
        Supplier<Apple> supplier = () -> new Apple(100,"red");
        Apple apple = supplier.get();
        System.out.println(apple);
    }

}
