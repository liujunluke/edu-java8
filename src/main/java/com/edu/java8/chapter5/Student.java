package com.edu.java8.chapter5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String name;

    private Integer age;

    private Integer score;

    private Integer classId;

}
