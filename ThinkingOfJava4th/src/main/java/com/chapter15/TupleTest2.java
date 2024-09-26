package com.chapter15;

import com.Entity.Americano;
import com.Entity.Chapter15.ThreeTuple;
import com.Entity.Chapter15.TwoTuple;

public class TupleTest2 {
    static TwoTuple<String, Integer> f() {
        return new TwoTuple<>("hi", 47);
    }

    static TwoTuple f2() {return new TwoTuple("hi", 47);}

    static ThreeTuple<Americano, String, Integer> f3() {return new ThreeTuple<>(new Americano(), "hi", 47);}

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(f3());
    }
}
