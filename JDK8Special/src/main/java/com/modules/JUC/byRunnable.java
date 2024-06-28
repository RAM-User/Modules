package com.modules.JUC;

import java.util.concurrent.RunnableFuture;

public class byRunnable {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.start();
    }
}
