package com.chapter2;

public class Person {
    public void eat(Apple apple) {
        Apple peeled = apple.getPeeled();
        System.out.println("Yummy");
    }

    class Peeler {
         public static Apple peel(Apple apple) {
            return apple;
        }
    }

    class Apple {
        Apple getPeeled() {
            return Peeler.peel(this);
        }
    }

    public static void main(String[] args) {

    }
}
