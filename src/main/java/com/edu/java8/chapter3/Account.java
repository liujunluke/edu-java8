package com.edu.java8.chapter3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Order order;

    private Integer age;

    private Optional<Order> orderOptional;

    public Account(Order order) {
        this.order = order;
    }

    public Account(Optional<Order> orderOptional) {
        this.orderOptional = orderOptional;
    }

}
