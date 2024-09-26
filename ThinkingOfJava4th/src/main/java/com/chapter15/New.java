package com.chapter15;

import com.Entity.chapter14.Candy;
import com.Entity.chapter14.Circle;

import java.util.*;

public class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<>();
    }

    public static <T> List<T> list() {
        return new ArrayList<T>();
    }

    public static <T> LinkedList<T> List() {
        return new LinkedList<>();
    }

    public static <T> Set<T> set() {
        return new HashSet<>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<>();
    }

    static void f(Map<Candy, List<Circle>> CandyCircle) {}

    public static void main(String[] args) {
        Map<String, List<String>> map = New.map();
        List<String> ls = New.list();
        Set<String> ss = New.set();
        Queue<String> qs = New.queue();

        // 显式调用
        f(New.<Candy, List<Circle>> map());
    }
}
