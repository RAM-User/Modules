package com.chapter2;

public class ThisKeyWord {

    int i = 0;

    ThisKeyWord increment() {
        i++;
        return this;
    }

    public void print() {
        System.out.println(i);
    }



    public static void main(String[] args) {
        ThisKeyWord thisKeyWord = new ThisKeyWord();
        thisKeyWord.increment().print();
    }
}
