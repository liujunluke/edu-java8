package com.edu.java8.chapter2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test10 {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan",90);
        Student student2 = new Student("lisi",70);
        Student student3 = new Student("wangwu",40);
        Student student4 = new Student("zhaoliu",60);
        Student student5 = new Student("yiran",60);
        List<Student> students = Arrays.asList(student1,student2,student3,student4,student5);

        /*Comparator<Student> comparator = Comparator.comparing(Student::getScore);
        students.sort(comparator);
        System.out.println(students);*/

        //Comparator.comparingInt()

        /*List<Integer> numbers = Arrays.asList(3,5,2,4);
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);*/

        Comparator<Student> comparator = Comparator.comparing(Student::getScore).reversed();
        //students.sort(comparator);
        //System.out.println(students);

        Comparator<Student> comparator1 = Comparator.comparing(Student::getName).reversed();
        Comparator<Student> newComparator = comparator.thenComparing(comparator1);
        students.sort(newComparator);
        System.out.println(students);

    }

}
