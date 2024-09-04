package com.Entity.chapter14;

public abstract class Shape {
    public void draw() {
        System.out.println(this + ".draw()");
    }

    abstract public String toString();
}