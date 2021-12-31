package com.example.mybatisdemo;

public class ThreadTest {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread is running.");
            }

        }).start();

        System.out.println("main thread is end.");
    }
}
