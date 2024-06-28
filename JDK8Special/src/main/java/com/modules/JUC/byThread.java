package com.modules.JUC;

public class byThread {
    public static void main(String[] args) {
        Thread thread = new Thread("printThread") {
            @Override
            public void run() {
                // job
                System.out.println(1);
            }
        };
        thread.start();
    }
}
