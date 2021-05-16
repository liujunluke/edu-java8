package com.edu.java8.chapter4;

public interface Person {

    default int score(){
        return 100;
    }

}
