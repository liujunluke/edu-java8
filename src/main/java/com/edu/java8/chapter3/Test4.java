package com.edu.java8.chapter3;


import java.util.Optional;

public class Test4 {

    public static void main(String[] args) {
        /*Optional<Account> accountOpt = Optional.empty();
        Optional<Order> orderOpt = Optional.empty();*/

        Optional<Account> accountOpt = Optional.of(new Account());
        Optional<Order> orderOpt = Optional.of(new Order());

        /*Optional<Product> productOptional = safeMethod(accountOpt, orderOpt);
        System.out.println(productOptional.orElse(new Product("默认商品名称")).getName());*/

        /*Optional<Product> productOptional = safeMethod2(accountOpt, orderOpt);
        System.out.println(productOptional.orElse(new Product("默认商品名称")).getName());*/

        //================================过滤========================================

        Product product = new Product("小米手机");
        /*if(product != null && product.getName().equals("小米手机")){
            System.out.println(product);
        }*/
        Optional<Product> productOptional = Optional.ofNullable(product).filter(product1 -> product1.getName().equals("小米手机"));
        productOptional.ifPresent(System.out::println);


    }

    public static Optional<Product> safeMethod2(Optional<Account> accountOpt,Optional<Order> orderOpt){
        return accountOpt.flatMap(account -> orderOpt.map(order -> method(account,order)));
    }

    public static Optional<Product> safeMethod3(Optional<Account> accountOpt,Optional<Order> orderOpt,Optional<Order> orderOpt2){
        return accountOpt.flatMap(account -> orderOpt.flatMap(order -> orderOpt2.map(order1 -> method2(account,order,order1))));
    }

    public static Optional<Product> safeMethod(Optional<Account> accountOpt,Optional<Order> orderOpt){
        if(accountOpt.isPresent() && orderOpt.isPresent()) {
            Product product
                    = method(accountOpt.get(), orderOpt.get());
            return Optional.ofNullable(product);
        }
        return Optional.empty();
    }

    public static Product method(Account account, Order order){
        if(account == null || order == null){
            return null;
        }
        return new Product("华为手机");
    }

    public static Product method2(Account account, Order order,Order order2){
        if(account == null || order == null){
            return null;
        }
        return new Product("华为手机");
    }

    public static String getProductNameByAge(Account account,int age){
        return Optional.ofNullable(account)
                .filter(acc -> acc.getAge() > age)
                .map(Account::getOrder)
                .map(Order::getProduct)
                .map(Product::getName)
                .orElse("默认商品名称");
    }

}
