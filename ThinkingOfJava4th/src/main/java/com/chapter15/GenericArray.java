package com.chapter15;

public class GenericArray<T> {
    private T[] array;

    // 生成
    @SuppressWarnings("unchecked")
    public GenericArray(int sz) {
        array = (T[]) new Object[sz];
    }

    // 增加
    public void put(int index, T item) {
        array[index] = item;
    }

    // 获取
    public T get(int index) {
        return array[index];
    }

    //
    public T[] rep(){
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10);
//        Integer[] rep1 = gai.rep();
        Object[] rep2 = gai.rep();
        for (Object o : rep2) {
            System.out.println(o);
        }
    }
}
