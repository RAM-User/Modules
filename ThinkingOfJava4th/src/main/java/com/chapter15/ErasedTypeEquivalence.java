package com.chapter15;

import java.util.ArrayList;

public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();

        System.out.println(c1.getSimpleName());
        System.out.println(c2.getSimpleName());

        // 擦除：c1 c2都被转型为Object
        System.out.println(c1 == c2);

    }
}
