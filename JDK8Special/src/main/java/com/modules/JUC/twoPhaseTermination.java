package com.modules.JUC;

import java.time.LocalDateTime;

public class twoPhaseTermination {

    public static void main(String[] args) throws InterruptedException {
        phaseThread phaseThread = new phaseThread();
        phaseThread.start();

        Thread.sleep(10000);
        phaseThread.end();
    }
}

class phaseThread {

    private Thread monitor;

    public void start() {
        monitor = new Thread(() -> {
            while (true) {
                Thread currentThread = Thread.currentThread();
                if (currentThread.isInterrupted()) {
                    System.out.println(LocalDateTime.now() + "打断后处理");
                    break;
                }

                try {
                    Thread.sleep(1000);
                    System.out.println(LocalDateTime.now() + "执行监控");
                }catch (InterruptedException e) {
                    e.printStackTrace();
                    currentThread.interrupt();
                }
            }
        }, "monitor");
        monitor.start();
    }

    public void end() {
        monitor.interrupt();
    }
}