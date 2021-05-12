package com.edu.java8.chapter2;

import java.util.Comparator;

public class StudentComparator {

    public int compareByScore(Student student1,Student student2){
        return student1.getScore() - student2.getScore();
    }

    public int compareByName(Student student1,Student student2){
        return student1.getName().compareToIgnoreCase(student2.getName());
    }

    public Comparator<Student> createComparator(){
        /*Comparator<Student> comparator = (s1,s2) -> {
            return this.compareByName(s1,s2);
        };*/
        Comparator<Student> comparator = this::compareByName;
        return comparator;
    }

}
