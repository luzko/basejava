package ru.javawebinar.basejava;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainConcurrency {
    private static int counter;
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        /*System.out.println(Thread.currentThread().getName());
        new Thread() {
            @Override
            public void run() {
                System.out.println(getName());
            }
        }.start();

        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    inc();
                }
            }).start();
        }

        Thread.sleep(500);
        System.out.println(counter);*/

        MainConcurrency mainConcurrency = new MainConcurrency();
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletionService completionService = new ExecutorCompletionService(executorService);



        for (int i = 0; i < 10000; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                }
            });
        }

        executorService.shutdown();
        System.out.println(counter);
    }

    public void inc() {
        lock.lock();
        try{
            counter++;
        } finally {
            lock.unlock();
        }
    }
}
