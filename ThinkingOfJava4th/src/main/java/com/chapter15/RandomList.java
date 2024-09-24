package com.chapter15;

import java.util.ArrayList;
import java.util.Random;

public class RandomList<T> {
   private ArrayList<T> storage =  new ArrayList<T>();
   private Random rand = new Random(47);
   public void add(T item) {
       storage.add(item);
   }
   public T select() {
       return storage.get(rand.nextInt(storage.size()));
   }

    public static void main(String[] args) {
        RandomList<Integer> integerRandomList = new RandomList<>();
        for (int i = 0; i < 100; i++) {
            integerRandomList.storage.add(i);
        }

        System.out.println(integerRandomList.select());
    }
}
