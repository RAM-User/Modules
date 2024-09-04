package com.chapter14;

import com.Entity.chapter14.Candy;
import com.Entity.chapter14.Cookie;

public class SweetShop {
    public static void main(String[] args) {
        System.out.println("Inside main");
        new Candy();
        System.out.println("After creating Candy");

        try {
            Class.forName("com.Entity.chapter14.Gum");
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("After Class.forName(\"Gum\")");

        new Cookie();
        System.out.println("After creating Cookie");
    }
}
