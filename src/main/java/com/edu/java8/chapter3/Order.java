package com.edu.java8.chapter3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Product product;

    private Optional<Product> productOptional;

    public Order(Product product) {
        this.product = product;
    }

    public Order(Optional<Product> productOptional) {
        this.productOptional = productOptional;
    }

}
