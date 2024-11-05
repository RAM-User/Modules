package com.chapter2;

import java.util.Objects;

class staticT {
    static int i = 47;
}
public class staticTest {
    public static void main(String[] args) {
        staticTest st1 = new staticTest();
        staticTest st2 = new staticTest();

        System.out.println(st1);
        System.out.println(st2);

        System.out.println(staticT.i++);

        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));

    }
}

