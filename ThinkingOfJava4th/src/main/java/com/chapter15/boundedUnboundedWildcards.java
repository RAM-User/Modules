package com.chapter15;

import java.util.ArrayList;
import java.util.List;

public class boundedUnboundedWildcards {
    public static void printList(List<?> list) {
//        list.add(6);
        list.add(null);
        for (Object o : list) {
            System.out.print(o + "  ");
        }
    }

    public static void printListBounded(List<? extends Number> list) {
        System.out.println();
        for (Number number : list) {
            System.out.print(number + "  ");
        }
    }

    public static void printListSuper(List<? super Number> list) {
        System.out.println();
        for (Object o : list) {
            System.out.print(o + "  ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        ArrayList<Number> numberList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            numberList.add(i);
        }


        printList(list);
        printListBounded(list);
        printListSuper(numberList);
    }
}
