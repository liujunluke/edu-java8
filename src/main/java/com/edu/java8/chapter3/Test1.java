package com.edu.java8.chapter3;

public class Test1 {

    public static void main(String[] args) {
        //需求：获取账户购买的产品的名字
        Account account = new Account();
        //getProductNameByAccount(account);//出现NullPointerException异常

        //System.out.println(getProductNameByAccount2(account));

        System.out.println(getProductNameByAccount3(account));

        //问题的根源：Java语言的设计者在当初参考了其他语言的设计，采用了空值建模，允许使用null值去赋值给任何引用变量

        //

    }

    public static String getProductNameByAccount(Account account){
        return account.getOrder().getProduct().getName();
    }

    /**
     * 整个方法充满了深层次的嵌套检查代码，牺牲了可读性和可维护性
     * @param account
     * @return
     */
    public static String getProductNameByAccount2(Account account){
        //加入检查代码
        if(account != null){
            Order order = account.getOrder();
            if(order != null){
                Product product = order.getProduct();
                if(product != null){
                    return product.getName();
                }
            }
        }
        return "未知";
    }

    /**
     * 避免了深层次嵌套检查代码，但是检查代码仍然存在，代码可维护性仍然很差
     * @param account
     * @return
     */
    public static String getProductNameByAccount3(Account account){
        String defaultName = "未知";
        if(account == null){
            return defaultName;
        }
        Order order = account.getOrder();
        if(order == null){
            return defaultName;
        }
        Product product = order.getProduct();
        if(product == null){
            return defaultName;
        }
        return product.getName();
    }

}
