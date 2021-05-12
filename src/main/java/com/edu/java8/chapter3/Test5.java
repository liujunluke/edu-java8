package com.edu.java8.chapter3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Test5 {

    public static void main(String[] args) {
        //Product product = getProduct();
        /*Optional<Product> productOptional = Optional.ofNullable(getProduct());
        productOptional.ifPresent(System.out::println);*/

//        Optional<Date> dateOptional = stringToDate("2345234");
//        dateOptional.ifPresent(System.out::println);

        System.out.println(route(Optional.ofNullable("abc")));

    }


    public static Product getProduct(){
        //return null;
        return new Product("苹果手机");
    }

    public static Optional<Date> stringToDate(String dateStr){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateStr);
            return Optional.ofNullable(date);
        } catch (ParseException e) {
            //e.printStackTrace();
            return Optional.empty();
        }
    }

    public static String route(Optional<String> routeName){
        List<String> routeNameList = Arrays.asList("account","order","product");
        return routeName.filter(routeNameList::contains)
                .map(name -> {
                    System.out.println("跳转页面：" + name);
                    return name;
                })
                .orElseGet(() -> {
                    System.out.println("跳转到默认页面");
                    return "index";
                });
    }

    public static Optional<String> route2(Optional<String> routeName){
        List<String> routeNameList = Arrays.asList("account","order","product");
        return routeName.filter(routeNameList::contains)
                .map(name -> {
                    System.out.println("跳转页面：" + name);
                    return name;
                });
    }

}
