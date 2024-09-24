package com.chapter15;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Automobile {

    /**
     * 单个对象类
     */
    public class Handler1 {

        private Automobile a;

        public Handler1(Automobile a) {
            this.a = a;
        }

        Automobile get() {
            return a;
        }
    }

    /**
     * 多个对象类
     */
    public class Handler2 {
        private Object a;

        public Handler2(Object a) {
            this.a = a;
        }

        public void set(Object a) {
            this.a = a;
        }

        public Object get() {
            return a;
        }

        public void vector() {
            Handler2 handler2 = new Handler2(new Automobile());
            Automobile a = (Automobile) handler2.get();

            handler2.set("Not an Automobile");
            String s = (String) handler2.get();

            handler2.set(1);
            Integer integer = (Integer) handler2.get();


        }
    }

    public class Holder3<T> {
        private T a;

        public Holder3(T a) {
            this.a = a;
        }

        public T get() {return a;}
        public void set(T a) {this.a = a;}
        public void test() {
            // 指明类型
            Holder3<Automobile> automobileHolder3 = new Holder3<>(new Automobile());
            Automobile automobile = automobileHolder3.get();

        }

    }

}
