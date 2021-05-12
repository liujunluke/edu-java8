package com.edu.java8.chapter3;

import java.util.Optional;

public class Test3 {

    public static void main(String[] args) {
        /*Account account = new Account();
        String name = getProductNameByAccount(account);
        System.out.println(name);*/

        /*Product product = new Product("华为手机");
        Order order = new Order(product);
        Account account = new Account(order);

        String name = getProductNameByAccount(account);
        System.out.println(name);*/

        //=======================扁平化=============================

        //Optional<Product> productOptional = Optional.of(new Product("华为手机"));
        Optional<Product> productOptional = Optional.ofNullable(null);
        Order order = new Order(productOptional);
        Optional<Order> orderOptional = Optional.of(order);
        Account account = new Account(orderOptional);

        String name = getProductNameByAccount2(account);
        System.out.println(name);

    }

    public static String getProductNameByAccount(Account account){
        /*Optional<Account> optional = Optional.ofNullable(account);
        Optional<Order> orderOptional = optional.map(account1 -> account1.getOrder());
        Optional<Product> productOptional = orderOptional.map(order -> order.getProduct());
        return productOptional.orElse(new Product("默认商品名称")).getName();*/

        Optional<String> stringOpt = Optional.ofNullable(account)
                .map(Account::getOrder)
                .map(Order::getProduct)
                .map(Product::getName);
        return stringOpt.orElse("默认商品名称");

    }

    public static String getProductNameByAccount2(Account account){
        Optional<Account> accountOptional = Optional.ofNullable(account);

        //无法map级联访问
        //Optional<Optional<Order>> orderOptional = accountOptional.map(Account::getOrderOptional);
        //orderOptional.map(orderOpt -> orderOpt.get)

        /*Optional<Order> orderOptional = accountOptional.flatMap(Account::getOrderOptional);
        Optional<Product> productOptional = orderOptional.flatMap(Order::getProductOptional);
        Optional<String> optional = productOptional.map(Product::getName);
        return optional.orElse("默认商品名称");*/

        //简写方式
        return Optional.ofNullable(account)
                .flatMap(Account::getOrderOptional)
                .flatMap(Order::getProductOptional)
                .map(Product::getName)
                .orElse("默认商品名称");

    }

}
