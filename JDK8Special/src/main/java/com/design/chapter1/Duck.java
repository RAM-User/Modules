package com.design.chapter1;

import lombok.Data;

@Data
public class Duck {
    private String color;

    public void swim() {
        System.out.println("Duck Swim");
    }

}
