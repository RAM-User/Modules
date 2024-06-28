package com.modules.JUC;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Async {
//    new CompletableFuture<String
public static void main(String[] args) throws InterruptedException {
    TimeUnit.MICROSECONDS.sleep(10);

//    CompletableFuture


    AtomicInteger r = new AtomicInteger(10);
    Thread thread = new Thread(() -> {
        System.out.println("start");
        r.set(11);
        System.out.println("start2");
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end");
    });

    thread.start();
    System.out.println("result: " + r);
    System.out.println("end2");
}
}
