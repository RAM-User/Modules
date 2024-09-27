package com.chapter15;

import com.util.Generator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Customer {
    private static long counter = 1;
    private final long id = counter++;

    private Customer() {
    }

    @Override
    public String toString() {
        return "Customer" + id;
    }

    public static Generator<Customer> generator() {
        return () -> new Customer();
    }

    static class Teller {
        private static long counter = 1;
        private final long id = counter++;

        private Teller() {
        }

        @Override
        public String toString() {
            return "Teller" + id;
        }

        public static Generator<Teller> generator = () -> new Teller();
    }

    public static class BankTeller {
        public static void serve(Teller t, Customer c) {
            System.out.println(t + "serves" + c);
        }

        public static void main(String[] args) {
            Random rand = new Random(47);
            LinkedList<Customer> line = new LinkedList<>();
            Generators.fill(line, Customer.generator(), 15);
            ArrayList<Teller> tellers = new ArrayList<>();
            Generators.fill(tellers, Teller.generator, 4);
            for (Customer customer : line) {
                serve(tellers.get(rand.nextInt(tellers.size())), customer);
            }
        }
    }
}
