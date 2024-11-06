package com.chapter7;

class Art {
    Art() {
        System.out.println("Art construtor");
    }
}

class Drawing extends Art {
    Drawing() {
        System.out.println("Drawing constructor");
    }
}

public class Cartoon extends Drawing {
    public Cartoon() {
        System.out.println("Cartoon constructor");
    }

    public static void main(String[] args) {
        Cartoon cartoon = new Cartoon();
    }
}
