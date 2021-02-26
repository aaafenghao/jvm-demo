package com.fh.asm01;

import java.util.Observable;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World");

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 30,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 50; i++) {
            threadPoolExecutor.submit(new Runnable() {
                public void run() {
                    try {
                        System.out.format("threadId %s threadName %s \n",Thread.currentThread().getId(),Thread.currentThread().getName());
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("-----------------");

    }
}
