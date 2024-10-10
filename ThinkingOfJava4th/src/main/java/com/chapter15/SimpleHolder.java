package com.chapter15;

public class SimpleHolder<T> {
    private T obj;

    public void set(T obj) {
        this.obj = obj;
    }

//    public Object get() {
//        return obj;
//    }

    public T get() {
        return obj;
    }

    public static void main(String[] args) {
        SimpleHolder simpleHolder = new SimpleHolder();
        simpleHolder.set("Item");
        String s = (String) simpleHolder.get();


    }

}
