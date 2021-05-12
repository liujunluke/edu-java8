package com.edu.java8.chapter3;

import java.util.Optional;

public class Test2 {

    public static void main(String[] args) {
        //空值Optional对象
        //Optional<Product> optional = Optional.empty();

        //没有正确使用Optional API
        //System.out.println(optional.get());//NoSuchElementException，使用get()必须要确保容器对象里面值存在

        //Product product = new Product("华为手机");
        /*Product product = null;
        Optional<Product> optional = Optional.of(product);
        System.out.println(optional.get().getName());*/

        //NullPointerException
        //不按照Optional规则去使用，还是会出现空指针异常问题

        Product product = getProduct();
        Optional<Product> optional = Optional.ofNullable(product);
        //System.out.println(optional.get().getName());//NoSuchElementException

        //===========================值获取======================================
        optional.ifPresent(prd -> System.out.println("商品名称：" + prd.getName()));

        Product product1 = optional.orElse(new Product("默认商品名称"));
        System.out.println("orElse " + product1.getName());

        Product product2 = optional.orElseGet(() -> {
            System.out.println("加载。。。");
            return new Product("延迟加载默认商品名称");
        });
        System.out.println("orElseGet " + product2.getName());

        Product product3 = optional.orElseThrow(() -> new RuntimeException("没有商品自定义异常"));
        System.out.println("orElseThrow " + product3.getName());

    }

    public static Product getProduct(){
        return null;
        //return new Product("小米手机");
    }

}
