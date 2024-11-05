package com.chapter5;

class Mug {
    Mug(int marker) {
        System.out.println("Mug(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}

public class Mugs {
    Mug mug1;
    Mug mug2;

    // 匿名内部类
    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
    }

    Mugs() {
        System.out.println("Mugs()");
    }
    Mugs(int i) {
        System.out.println("Mugs(int i)");
    }

    public static void main(String[] args) {
        new Mugs();
        new Mugs(1);
    }
}
