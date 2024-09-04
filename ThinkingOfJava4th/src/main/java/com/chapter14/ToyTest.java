package com.chapter14;

import java.lang.reflect.Method;

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println(
                "Class name: " + cc.getName() + "is interface? ["
                        + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class c = null;
        try {
            c = Class.forName("com.Entity.chapter14.FancyToy");
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        printInfo(c);

        Class superclass = c.getSuperclass();

        Object obj = null;
        try {
            obj = superclass.newInstance();
        }catch (InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        printInfo(obj.getClass());

    }
}
