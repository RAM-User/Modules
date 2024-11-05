package com.chapter5;

public class Flower {
    int petalCount = 0;
    String s = "initial value";

    Flower(int petals) {
        petalCount = petals;
    }

    Flower(String ss) {
        System.out.println(("Constructor w/ int arg only, s = " + ss));
        s = ss;
    }

    Flower(String s, int petals) {
        this(petals);
        this.s = s;
        System.out.println("string & int arg");
    }
    Flower() {
        this("hi", 47);
        System.out.println("default constructor (no arg)");
    }
    void printPetalCount() {
//        this(11); 必须在构造器中调用
        System.out.println("petalCount = " + petalCount + ", s = " + s);
    }

    public static void main(String[] args) {
//        Flower f;
//        System.out.println(f.petalCount); 未初始化使用
        Flower flower = new Flower();
        flower.printPetalCount();
    }

}
