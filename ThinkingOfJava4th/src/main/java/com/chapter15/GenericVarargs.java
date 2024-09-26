package com.chapter15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 可变参数泛型方法
 */
public class GenericVarargs {
    public static <T> List<T> makeList(T... args) {
        ArrayList<T> result = new ArrayList<>();
        for (T arg : args) {
            result.add(arg);
        }
        return result;
    }

    /**
     * Arrays.asList
     * @param args
     */
    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);

        ls = makeList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(ls);
        Arrays.asList();
    }
}
