package com.chapter15;

import java.util.ArrayList;
import java.util.List;

public class FilledListMaker<T> {
    List<T> create(T t, int n) {
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(t);
        }
        return result;
    }

    public static void main(String[] args) {
        FilledListMaker<String> stringFilledListMaker = new FilledListMaker<>();
        List<String> list = stringFilledListMaker.create("Hello", 4);
        System.out.println(list);
    }
}
