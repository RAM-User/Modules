package com.design.chapter1;

public class GreenHeadDuck extends Duck implements DuckFly{
    private String color = "green";

    @Override
    public void fly() {
        System.out.println("pa pa pa fly");
    }
}
