package com.modules.JVM;

public class ClassLoader {
    static int i = 1;
    public static void main(String[] args) {
        new ClassLoader();
        System.out.println(i);

    }

    public static void tt() {
        i = 4;
    }

    {
        i = 2;
    }

    static {
        i = 3;
    }
}


