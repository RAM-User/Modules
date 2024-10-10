package com.chapter15;

public class GenericArray2<T> {
    private Object[] array;
    public GenericArray2(int sz) {
        array = new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }
    @SuppressWarnings("unchecked")
    public T[] rep(){
        return (T[]) array;
    }

    public static void main(String[] args) {
        GenericArray2<Integer> gai2 = new GenericArray2<>(10);
        for (int i = 0; i < 10; i++) {
            gai2.put(i, i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(gai2.get(i));
        }
        System.out.println();
        try {
            Integer[] rep = gai2.rep();
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}
