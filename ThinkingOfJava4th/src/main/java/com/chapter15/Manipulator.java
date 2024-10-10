package com.chapter15;

class HasF {
    public void f() {
        System.out.println("HasF.f()");
    }
}
public class Manipulator<T extends HasF> {
    private T obj;

    public Manipulator(T x) {
        this.obj = x;
    }

    public void manipulate() {obj.f();}

    public static void main(String[] args) {
        HasF hasF = new HasF();
        Manipulator<HasF> hasFManipulator = new Manipulator<>(hasF);
        hasFManipulator.manipulate();
    }
}
