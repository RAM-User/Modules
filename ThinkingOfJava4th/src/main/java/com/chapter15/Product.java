package com.chapter15;

import com.util.Generator;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Product {
    private final int id;

    private String description;
    private double price;

    public Product(int IDnumber, String descr, double price) {
        id = IDnumber;
        description = descr;
        System.out.println(toString());
    }

    public void priceChange(double change) {
        price += change;
    }

    public static Generator<Product> generator = new Generator<Product>() {
        private Random rand = new Random(47);

        @Override
        public Product next() {
            return new Product(rand.nextInt(1000), "Test", Math.round(rand.nextDouble() * 1000.0) + 0.99);
        }
    };

    class Shelf extends ArrayList<Product> {
        public Shelf(int nProducts) {
            Generators.fill(this, Product.generator, nProducts);
        }
    }

    class Aisle extends ArrayList<Shelf> {
        public Aisle(int nShelves, int nProduct) {
            for (int i = 0; i < nShelves; i++) {
                add(new Shelf(nProduct));
            }
        }
    }

    class CheckoutStand{}
    class Office{}

    public class Store extends ArrayList<Aisle> {
        private ArrayList<CheckoutStand> checkoutStands = new ArrayList<>();
        private Office office = new Office();
        public Store(int nAisles, int nShelves, int nProducts) {
            for (int i = 0; i < nAisles; i++) {
                add(new Aisle(nShelves, nProducts));
            }
        }

        @Override
        public String toString() {
            return "Store{" +
                    "checkoutStands=" + checkoutStands +
                    ", office=" + office +
                    '}';
        }
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public void test() {
        System.out.println(new Store(14, 5, 10));
    }
}
