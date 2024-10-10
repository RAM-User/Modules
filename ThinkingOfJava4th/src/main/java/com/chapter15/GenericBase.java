package com.chapter15;

public class GenericBase<T> {
    private T element;
    public void set(T arg) {arg = element;}
    public T get() {return element;}

}

class Derived1<T> extends GenericBase<T> {}

class Derived2<T> extends GenericBase {}

//class Derived3 extends GenericBase<?> {}

class ErasureAndInheritance {

    @SuppressWarnings("unchedcked")
    public static void main(String[] args) {
        Derived2 derived2 = new Derived2();
        Object obj = derived2.get();
        derived2.set(obj);
    }
}