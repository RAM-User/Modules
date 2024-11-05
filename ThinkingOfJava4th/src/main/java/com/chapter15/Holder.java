package com.chapter15;

import java.util.Objects;

public class Holder<T> {
    private T value;

    public Holder() {
    }

    public Holder(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        return value.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public static void main(String[] args) {
        Holder<Apple> Apple = new Holder<>(new Apple());
        com.chapter15.Apple d = Apple.getValue();
        Apple.setValue(d);

        Holder<? extends Fruit> fruit = Apple;
        Fruit p = fruit.getValue();

        d = (com.chapter15.Apple) fruit.getValue();

        try {
            Orange c = (Orange) fruit.getValue();
        }catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        System.out.println(fruit.equals(d));
    }

    
}
