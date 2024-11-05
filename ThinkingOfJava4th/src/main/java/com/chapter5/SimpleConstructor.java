package com.chapter5;

class Rock {
    Rock() {
        System.out.println("Rock ");
    }
    Rock(int i) {
        System.out.println("Rock " + i);
    }
}
public class SimpleConstructor {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Rock();
            new Rock(i);
        }
    }
}
