package com.leetcode;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MultThread {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("===" + Thread.currentThread().getName());
                    if (semaphore.availablePermits() == 0) {
                        System.out.println("wait");
                    }
                    semaphore.tryAcquire(1000, TimeUnit.MILLISECONDS);
                    System.out.println(Thread.currentThread().getName() + "成功进入停车场");
                    Thread.sleep(new Random().nextInt(1000));
                    System.out.println(Thread.currentThread().getName() + "离开停车场");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, i + " 车号");
            thread.start();
        }
    }
}
