package com.chapter15;

abstract class GenericWithCreate<T> {
    final T element;

    public GenericWithCreate() {
        element = create();
    }
    abstract T create();
}

class X{}

class Creator extends GenericWithCreate<X>{
    X create() {return new X();}
    void f(){
        System.out.println(element.getClass().getSimpleName());
    }
}



