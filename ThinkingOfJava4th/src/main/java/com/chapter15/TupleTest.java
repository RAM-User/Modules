package com.chapter15;

import com.Entity.Chapter15.TwoTuple;

import java.util.Map;

public class TupleTest {
    static TwoTuple<String, Integer> f() {
        return new TwoTuple<String, Integer>("hi", 17);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);

        System.out.println(f());

    }
}
