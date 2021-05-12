package com.edu.java8.chapter2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String name;

    private Integer score;

    public Student(String name) {
        this.name = name;
    }

    public static int compareStaticByScore(Student student1, Student student2){
        return student1.getScore() - student2.getScore();
    }

    public static int compareStaticByName(Student student1, Student student2){
        return student1.getName().compareToIgnoreCase(student2.getName());
    }

    public int compareByScore(Student student){
        return this.getScore() - student.getScore();
    }

    public int compareByName(Student student){
        return this.getName().compareToIgnoreCase(student.getName());
    }

}
