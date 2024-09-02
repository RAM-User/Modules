package com.chapter15;

public class Automobile {

    public class Handler1 {

        private Automobile a;

        public Handler1(Automobile a) {
            this.a = a;
        }

        Automobile get() {return a;}
    }

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

        public static void main(String[] args) {
//            Handler2 handler2 = new Handler2(new Automobile());
        }
    }
}
