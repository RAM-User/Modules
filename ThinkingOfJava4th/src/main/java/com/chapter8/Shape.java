package com.chapter8;

import java.util.Random;

class Circle extends Shape {
    public void draw() {
        System.out.println("draw Circle");
    }
    public void erase() {
        System.out.println("erase Circle");
    }
}

class Square extends Shape {
    public void draw() {
        System.out.println("draw Square");
    }
    public void erase() {
        System.out.println("erase Square");
    }
}

class RandomShapeGenerator {
    private Random rand = new Random(47);
    public Shape next() {
        switch (rand.nextInt(1)) {
            default:
            case 0: return new Circle();
            case 1: return new Square();
        }
    }
}
public class Shape {
    public void draw() {}
    public void erase() {}
}
